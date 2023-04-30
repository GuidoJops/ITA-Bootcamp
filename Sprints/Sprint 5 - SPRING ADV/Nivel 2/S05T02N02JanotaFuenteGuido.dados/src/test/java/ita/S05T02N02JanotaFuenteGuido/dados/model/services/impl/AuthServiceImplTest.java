package ita.S05T02N02JanotaFuenteGuido.dados.model.services.impl;

import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.AuthRequest;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.AuthResponse;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N02JanotaFuenteGuido.dados.model.services.IPlayerService;
import ita.S05T02N02JanotaFuenteGuido.dados.security.jwt.JwtUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @Mock private AuthenticationManager authenticationManager;
    @Mock private IPlayerService playerService;
    @Mock private JwtUtils jwtUtils;

    @InjectMocks private AuthServiceImpl authServiceImpl;

    private AuthRequest authRequest;

    @BeforeEach
    void setUp(){
        authRequest = AuthRequest.builder()
                .name("testname")
                .userName("test@gmail.com")
                .password("testpswd")
                .build();
    }

    @Test
    void shouldRegisterUser(){
        //given
        PlayerDto playerDto = PlayerDto.builder()
                .id("id")
                .name(authRequest.getName())
                .userName(authRequest.getUserName())
                .registDate(new Date())
                .winSuccess(0)
                .build();

        Mockito.when(playerService.playerExist(authRequest.getUserName())).thenReturn(false);
        Mockito.when(playerService.createPlayer(authRequest)).thenReturn(playerDto);

        //when
        PlayerDto result = authServiceImpl.registerUser(authRequest);

        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getUserName()).isEqualTo(authRequest.getUserName());
    }

    @Test
    void shouldNotRegisterUser_UserNameTaken(){
        //given
        Mockito.when(playerService.playerExist(authRequest.getUserName())).thenReturn(true);

        //when
        PlayerDto result = authServiceImpl.registerUser(authRequest);

        //then
        Assertions.assertThat(result).isNull();

    }

    @Test
    void shouldLoginUser(){
        //given
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                authRequest.getUserName(),
                authRequest.getPassword());

        String token = "testToken";

        Mockito.when(authenticationManager.authenticate(Mockito.any(Authentication.class)))
                .thenReturn(authentication);
        Mockito.when(jwtUtils.generateToken(authentication)).thenReturn(token);

        //when
       AuthResponse result = authServiceImpl.loginUser(authRequest);

        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getToken()).isEqualTo(token);

    }

    @Test
    void shouldNotLoginUser_throwsException(){
        //given
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                authRequest.getUserName(),
                authRequest.getPassword());
        String token = "testToken";

        Mockito.when(authenticationManager.authenticate(Mockito.any(Authentication.class)))
                .thenThrow(new AuthenticationException("Credenciales incorrectas"){});

        //when
        AuthResponse result = authServiceImpl.loginUser(authRequest);

        //then
        Assertions.assertThat(result).isNull();


    }
}