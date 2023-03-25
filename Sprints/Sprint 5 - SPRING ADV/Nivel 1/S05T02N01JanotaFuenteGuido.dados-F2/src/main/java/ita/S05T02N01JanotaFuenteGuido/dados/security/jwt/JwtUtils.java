package ita.S05T02N01JanotaFuenteGuido.dados.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ita.S05T02N01JanotaFuenteGuido.dados.security.CustomUserDetails;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JwtUtils {


    private final long JWT_EXPIRATION_MS = 3000000;  // 300000 = 5 minutos

    @Value("${app.jwt.secret}")
    private String JWT_SECRET;

    @Autowired
    private HttpServletResponse response;

    //Genera el Token
    public String generateToken(Authentication auth) {
        CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
        log.info(user.toString());

        //Datos del HEADER
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "Bearer Token");
        header.put("alg", "HS512");

        //Datos para PAYLOAD
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("id", user.getId());
        extraClaims.put("admin", user.isAdmin());

        //Genera Token
        String token = Jwts.builder()
                .setHeader(header)
                .setSubject(user.getUsername())
                .addClaims(extraClaims)
                .setIssuer("Dice-App")
                .setIssuedAt( new Date())
                .setExpiration(new Date (System.currentTimeMillis()+ JWT_EXPIRATION_MS))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
        addTokenToResponseHeader(token);
        log.info("Token: " + token);
        return token;
    }

    //Extrae usuario del token
    public String getUsernameFromJWT (String token) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

    }

    //Valida el Token
    public boolean validateToken (String token) {
        try{
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthenticationCredentialsNotFoundException("Token expirado o incorrecto");
        }
    }


    //Agrega token en el Header del HttpServletResponse
    public void addTokenToResponseHeader(String token) {
        response.setHeader("Authorization", "Bearer " + token);
        log.info("Token agregado en el Header del Response");

    }


}
