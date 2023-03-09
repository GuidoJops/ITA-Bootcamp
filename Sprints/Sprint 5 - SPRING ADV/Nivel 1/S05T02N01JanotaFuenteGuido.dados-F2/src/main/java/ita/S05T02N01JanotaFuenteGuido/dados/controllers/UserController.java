package ita.S05T02N01JanotaFuenteGuido.dados.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("")
@Slf4j
public class UserController {
	
	
	@GetMapping("/test")
	public ResponseEntity<?> test(){
		log.info("-----Si siiii------");
		var auth = SecurityContextHolder.getContext().getAuthentication();
		log.info("Usuario: {}", auth.getPrincipal());
		log.info("Permisos: {}", auth.getAuthorities());
		log.info("Usuario: {}", auth.isAuthenticated());

		return ResponseEntity.ok("TOKEN");
	}

}
