package ita.S05T02N01JanotaFuenteGuido.dados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.services.IGameService;
import ita.S05T02N01JanotaFuenteGuido.dados.model.services.IPlayerService;

@RestController
public class PlayerController {

	@Autowired
	private IPlayerService playerService;
	
	
	@GetMapping("players")
	public ResponseEntity<List> listPlayers(){
		List<PlayerDto> playersDto = playerService.getAllPlayers();
		if (playersDto.isEmpty()) {
			System.out.println("No hay Jugadores en el sistema.");
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(playersDto, HttpStatus.OK);
	}
	
	
	@PostMapping("players")
	public ResponseEntity<?> registerPlayer(@RequestParam String name) {
		PlayerDto playerDto = playerService.register(name);
		if(playerDto==null) {
			return new ResponseEntity<>("EL nombre del Jugador ya existe.", HttpStatus.NOT_ACCEPTABLE);//CHEQUEAR CODIGO ERROR
		}
		return new ResponseEntity<>(playerDto, HttpStatus.CREATED);
		}
	
	@PutMapping("players")
	public ResponseEntity<?> changeNamePlayer(@RequestBody PlayerDto playerDto) {
		PlayerDto _playerDto = playerService.changeName(playerDto);
		if(_playerDto==null) {
			return new ResponseEntity<>("EL nombre del Jugador NO existe.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(_playerDto, HttpStatus.CREATED);
		}

		

}
