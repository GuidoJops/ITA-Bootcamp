package ita.S05T02N01JanotaFuenteGuido.dados.controllers;

import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.AuthRequest;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.AuthResponse;
import ita.S05T02N01JanotaFuenteGuido.dados.model.services.IAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest authRequest) {
        if (authService.registerUser(authRequest) == null){
            return new ResponseEntity<>("Nombre de Usuario ya existe", HttpStatus.BAD_REQUEST); // o CONFLICT??
        }
        log.info("Usuario Registrado");
        return new ResponseEntity<>("Usuario registrado con éxito!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        AuthResponse authResponse = authService.loginUser(authRequest);
//        log.info(token);
        if (authResponse.getToken() == null){
            return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.BAD_REQUEST); // o CONFLICT??
        }
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @GetMapping("/principal")
    public ResponseEntity<String> whoIsPrincipal(){
        log.info(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return  new ResponseEntity<>("Si tienes acceso puedes ver " +
                "el usuario principal en la consola", HttpStatus.OK);
    }



}
