package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.AuthResponse;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.AuthRequest;
import ita.S05T02N01JanotaFuenteGuido.dados.security.CustomUserDetails;
import ita.S05T02N01JanotaFuenteGuido.dados.security.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    public PlayerDto registerUser(AuthRequest authRequest) { // QUE DEVUELVA UN BOOLEANO?

        if (playerService.playerExist(authRequest.getUserName())) {
            log.info("EL nombre de usuario ya existe");
            return null;
        }
        return playerService.createPlayer(authRequest);
    }

    //TODO Agregar retorno con inicio de sesión fallido
    @Override
    public AuthResponse loginUser(AuthRequest authRequest) {
        AuthResponse authResponse = new AuthResponse();

        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getUserName(),
                authRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(auth);
        String token = jwtUtils.generateToken(auth);

        authResponse.setUserName(authRequest.getUserName());
        authResponse.setToken(token);

        log.info("Usuario '{}' ha iniciado sesión",  authRequest.getUserName());
        return authResponse;
    }
}
