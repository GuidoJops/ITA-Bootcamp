package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.AuthResponse;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.AuthRequest;
import ita.S05T02N01JanotaFuenteGuido.dados.security.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IPlayerService playerService;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public PlayerDto registerUser(AuthRequest authRequest) {
        if (playerService.playerExist(authRequest.getUserName())) {
            return null;
        }
        return playerService.createPlayer(authRequest);
    }

    @Override
    public AuthResponse loginUser(AuthRequest authRequest) {
        try{
            Authentication auth = getAuthentication(authRequest);
            SecurityContextHolder.getContext().setAuthentication(auth);
            String token = jwtUtils.generateToken(auth);

            AuthResponse authResponse = new AuthResponse();
            authResponse.setUserName(authRequest.getUserName());
            authResponse.setToken(token);

            log.info("Usuario '{}' ha iniciado sesión",  authRequest.getUserName());
            return authResponse;

        } catch (AuthenticationException e) {
            log.error("Error al autenticar usuario: " + e.getMessage());
        }
        return null;
    }

    private Authentication getAuthentication(AuthRequest authRequest) throws AuthenticationException {
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
               authRequest.getUserName(),
               authRequest.getPassword()
        ));

    }


}
