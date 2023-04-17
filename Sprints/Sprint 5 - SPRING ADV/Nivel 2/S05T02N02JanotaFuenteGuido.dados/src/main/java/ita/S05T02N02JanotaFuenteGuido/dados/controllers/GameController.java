package ita.S05T02N02JanotaFuenteGuido.dados.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.GameDto;
import ita.S05T02N02JanotaFuenteGuido.dados.model.services.IGameService;

@RestController
public class GameController {

	private final IGameService gameService;

	public GameController(IGameService gameService) {
		this.gameService = gameService;
	}

	@PostMapping("players/{id}/games")
	@PreAuthorize("#id == principal.id")
	public ResponseEntity<?> playGame(@PathVariable String id) {
		GameDto gameDto = gameService.newGame(id);
		if (gameDto==null) {
            return new ResponseEntity<>("NO hay jugadores con el id: "+id, HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<>(gameDto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("players/{id}/games")
	@PreAuthorize("hasRole ('ADMIN')")
	public ResponseEntity<String> deleteGames(@PathVariable String id) {
		if (!gameService.deleteAllGamesByPlayerId(id)) {
            return new ResponseEntity<>("NO hay jugadores con el id: "+id, HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<>("Se han borrado todas las partidas del Jugador con id: " + id, HttpStatus.OK);


	}
	

}
