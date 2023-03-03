package ita.S05T02N01JanotaFuenteGuido.dados.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.GameDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.services.IGameService;

@RestController
public class GameController {
	
	
	@Autowired
	private IGameService gameService;
		
	
	@PostMapping("players/{id}/games")
	public ResponseEntity<?> playGame(@PathVariable String id) {
		GameDto gameDto = gameService.newGame(id);
		if (gameDto==null) {
            return new ResponseEntity<>("NO hay jugadores con el id: "+id, HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<>(gameDto, HttpStatus.CREATED);


	}
	
	@DeleteMapping("players/{id}/games")
	public ResponseEntity<String> deleteGames(@PathVariable String id) {
		if (!gameService.deleteAllGamesByPlayerId(id)) {
            return new ResponseEntity<>("NO hay jugadores con el id: "+id, HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<>("Se han borrado todas las partidas del Jugador con id: " + id, HttpStatus.OK);


	}
	

}
