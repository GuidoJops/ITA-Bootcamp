package ita.S05T02N01JanotaFuenteGuido.dados.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtGenerator {

    private final long JWT_EXPIRATION = 300000;  // equivale a 5 minutos
    private final String JWT_SECRET = "dG9wc2VjcmV0a2V5dG9wc2VjcmV0a2V5dG9wc2VjcmV0a2V5dG9wc2VjcmV0a2V5";

//    //Genera el Token
//    public String generateToken(Authentication authentication) {
//        log.info(authentication.getName());
//        log.info(authentication.getPrincipal().toString());
//
//        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
//
//        String token = Jwts.builder()
//                .setSubject(userPrincipal.getUsername())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(new Date().getTime() + JWT_EXPIRATION))
//                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
//                .compact();
//        return token;
//    }


    //Genera el Token
    public String generateToken(Authentication authentication) {
        log.info(authentication.getPrincipal().toString());

        String userName = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date (currentDate.getTime() + JWT_EXPIRATION);

        String token = Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();

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
}
