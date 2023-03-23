package ita.S05T02N01JanotaFuenteGuido.dados.security.jwt;

import ita.S05T02N01JanotaFuenteGuido.dados.security.CustomUserDetailsService;
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
public class JwtSecurityFilter extends OncePerRequestFilter {

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
            if (jwtToken != null && jwtUtils.validateToken(jwtToken)) { // SOLO 2da CONDICION??
                String username = jwtUtils.getUsernameFromJWT(jwtToken);
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                WebAuthenticationDetails webAuthenticationDetails =
                        new WebAuthenticationDetailsSource().buildDetails(request);

                authenticationToken.setDetails(webAuthenticationDetails);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception e) {
            log.error("No se pudo authenticar el usuario. {}", e.getMessage());
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




//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//
//        String token = getJwtFromRequest(request);
//        if(token!=null && jwtUtils.validateToken(token)){
//            String userName = jwtUtils.getUsernameFromJWT(token);
//
//            UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
//                    null, userDetails.getAuthorities());
//            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        }
//        filterChain.doFilter(request,response);
//    }
//
//    private String getJwtFromRequest(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")){
//            return bearerToken.substring(7, bearerToken.length());
//        }
//        return null;
//    }
}
