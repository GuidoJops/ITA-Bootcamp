package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.UserDto;
import ita.S05T02N01JanotaFuenteGuido.dados.security.jwt.JwtGenerator;
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
    private JwtGenerator jwtGenerator;

    @Override
    public PlayerDto registerUser(UserDto userDto) { // QUE DEVUELVA UN BOOLEANO?

        if (playerService.playerExist(userDto.getUserName())) {
            log.info("EL nombre de usuario ya existe");
            return null;
        }
        return playerService.createPlayer(userDto);
    }

    @Override
    public String loginUser(UserDto userDto) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDto.getUserName(),
                userDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(auth);
        String token = jwtGenerator.generateToken(auth);
        log.info("Bienvenido {}",  userDto.getUserName());
        return token;
    }
}
