package ita.S05T02N01JanotaFuenteGuido.dados.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.services.IPlayerService;

@RestController
//PONER URL GENERAL 'players'
public class PlayerController {
	
	@Autowired
	private IPlayerService playerService;
	
	
	@GetMapping("players")
	public ResponseEntity<List<PlayerDto>> listPlayers(){
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

	@GetMapping("players/{id}/games")
	public ResponseEntity<?> getPlayerGames(@PathVariable int id) {
		List <Game> games =	playerService.gamesByPlayerId(id);
		if (games==null) {
            return new ResponseEntity<>("NO hay jugadores con el id: "+id, HttpStatus.NOT_FOUND);
            
		} else if (games.isEmpty()) {
			System.out.println("El jugador con id: "+id+" no tiene juegos");
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		}
        return new ResponseEntity<>(games, HttpStatus.OK);
	}

	@GetMapping("players/ranking")
	public ResponseEntity<?> getPlayersRanking(){
		Map<String, Double> playersRanking = playerService.getAllPlayersRanking();
		if (playersRanking.isEmpty()) {
			System.out.println("No hay Jugadores en el sistema.");
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(playersRanking, HttpStatus.OK);
	}
	
	@GetMapping("players/ranking/winner")
	public ResponseEntity<?> getWinnerPlayer(){
		PlayerDto playerDto = playerService.getWinner();

		if (playerDto==null) {
			System.out.println("No hay Jugadores en el sistema.");
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(playerDto, HttpStatus.OK);
	}
	
	@GetMapping("players/ranking/loser")
	public ResponseEntity<?> getLoserPlayer(){
		PlayerDto playerDto = playerService.getLoser();

		if (playerDto==null) {
			System.out.println("No hay Jugadores en el sistema.");
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(playerDto, HttpStatus.OK);
	}
	
	
	
}
