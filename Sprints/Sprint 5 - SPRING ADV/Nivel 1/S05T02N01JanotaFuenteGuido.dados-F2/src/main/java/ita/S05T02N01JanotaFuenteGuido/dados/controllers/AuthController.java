package ita.S05T02N01JanotaFuenteGuido.dados.controllers;

import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.UserDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IPlayerService playerService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        if (playerService.registerUser(userDto) == null){
            return new ResponseEntity<>("Nombre de Usuario ya existe", HttpStatus.BAD_REQUEST); // o CONFLICT??
        }
        return new ResponseEntity<>("Usuario registrado con éxito!", HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
//        if (playerService.loginUser(userDto)){
//            return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.BAD_REQUEST); // o CONFLICT??
//        }
        playerService.loginUser(userDto);
        return new ResponseEntity<>("Bienvenido " + userDto.getUserName(), HttpStatus.OK);

    }



}