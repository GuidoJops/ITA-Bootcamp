package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import ita.S05T02N01JanotaFuenteGuido.dados.model.converter.EntityDtoConverter;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.ERole;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Role;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.UserDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IPlayerRepository;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Slf4j
@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private IPlayerRepository playerRepository;
    @Autowired
    private EntityDtoConverter converter;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public PlayerDto registerUser(UserDto userDto) { // QUE DEVUELVA UN BOOLEANO?
        if (playerRepository.existsByUserName(userDto.getUserName())) {
            log.info("EL nombre de usuario ya existe");
            return null;
        }
        Role roles = roleRepository.findByType(ERole.ROLE_USER).get(); // role de USER por defecto
        Player player = new Player();
        player.setUserName(userDto.getUserName());
        player.setPassword(passwordEncoder.encode(userDto.getPassword()));
        player.setRoles(Collections.singletonList(roles));
        log.info("Usuario Registrado con éxito!");

        return converter.toPlayerDto(playerRepository.save(player));
    }

    @Override
    public void loginUser(UserDto userDto) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDto.getUserName(),
                userDto.getPassword()));
        log.info("Bienvenido {}",  userDto.getUserName());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
