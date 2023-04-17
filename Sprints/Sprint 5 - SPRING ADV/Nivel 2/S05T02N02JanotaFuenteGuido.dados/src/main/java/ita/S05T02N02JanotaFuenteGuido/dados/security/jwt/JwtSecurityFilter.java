package ita.S05T02N02JanotaFuenteGuido.dados.security.jwt;

import ita.S05T02N02JanotaFuenteGuido.dados.security.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Slf4j
public class JwtSecurityFilter extends OncePerRequestFilter { // Garantiza solo UNA ejecución por request

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        try {
            String jwtToken = getJwtTokenFromRequest(request);
            //Si el request tiene un token válido actualiza el Authentication Context con los datos del Usuario
            if (jwtToken != null && jwtUtils.validateToken(jwtToken)) {
                String username = jwtUtils.getUsernameFromJWT(jwtToken);
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                //Objeto que contiene Información adicional sobre la request (IP, URL, etc)
                WebAuthenticationDetails webAuthenticationDetails =
                        new WebAuthenticationDetailsSource().buildDetails(request);
                //Se pasan los detalles de usuario para autenticación
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                //Se agrega la info adicional
                authenticationToken.setDetails(webAuthenticationDetails);
                //Actualiza SecurityContextHolder con datos de autenticación
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception e) {
            log.error("No se pudo autenticar el usuario. {}", e.getMessage());
        }
        filterChain.doFilter(request, response);
    }

    private String getJwtTokenFromRequest(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (StringUtils.hasText(header) && header.startsWith("Bearer")) {
            return header.substring(7);
        }
        return null;
    }

}
