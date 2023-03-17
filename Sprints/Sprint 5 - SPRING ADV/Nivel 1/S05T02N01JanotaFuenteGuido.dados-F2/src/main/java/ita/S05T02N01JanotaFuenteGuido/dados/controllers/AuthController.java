package ita.S05T02N01JanotaFuenteGuido.dados.controllers;

import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.UserDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.services.IAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        if (authService.registerUser(userDto) == null){
            return new ResponseEntity<>("Nombre de Usuario ya existe", HttpStatus.BAD_REQUEST); // o CONFLICT??
        }
        return new ResponseEntity<>("Usuario registrado con éxito!", HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
        String token = authService.loginUser(userDto);
        log.info(token);
        if (token == null){
            return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.BAD_REQUEST); // o CONFLICT??
        }

        return new ResponseEntity<>(token, HttpStatus.OK);

    }



}
