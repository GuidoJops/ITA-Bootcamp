package ita.S05T02N01JanotaFuenteGuido.dados.controllers;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.services.IPlayerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/players")
public class PlayerController {
	
	@Autowired
	private IPlayerService playerService;

	@PreAuthorize("#id == principal.id or hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<?> changePayerName(@PathVariable String id, @RequestParam String name) {
		PlayerDto _playerDto = playerService.changePlayerName(id, name);
		if(_playerDto==null) {
			return new ResponseEntity<>("EL Jugador que se quiere modificar NO existe, revisa el ID.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(_playerDto, HttpStatus.OK);
	}

	@PreAuthorize("#id == principal.id or hasRole('ADMIN')")
	@GetMapping("/{id}/games")
	public ResponseEntity<?> getPlayerGames(@PathVariable String id) {
		List <Game> games =	playerService.getGamesByPlayerId(id);
		if (games==null) {
            return new ResponseEntity<>("NO hay jugadores con el id: "+id, HttpStatus.NOT_FOUND);
            
		} else if (games.isEmpty()) {
			log.info("El jugador con id: "+id+" no tiene juegos");
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		}
        return new ResponseEntity<>(games, HttpStatus.OK);
	}

	@GetMapping("/ranking")
	public ResponseEntity<?> getPlayersRanking(){
		Map<String, Double> playersRanking = playerService.getAllPlayersRanking();
		if (playersRanking.isEmpty()) {
			log.info("No hay Jugadores en el sistema.");
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(playersRanking, HttpStatus.OK);
	}
	
	@GetMapping("/ranking/winner")
	public ResponseEntity<?> getWinnerPlayer(){
		PlayerDto playerDto = playerService.getPlayerWinner();

		if (playerDto==null) {
			log.info("No hay Jugadores en el sistema.");
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(playerDto, HttpStatus.OK);
	}
	
	@GetMapping("/ranking/loser")
	public ResponseEntity<?> getLoserPlayer(){
		PlayerDto playerDto = playerService.getPlayerLoser();

		if (playerDto==null) {
			log.info("No hay Jugadores en el sistema.");
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(playerDto, HttpStatus.OK);
	}

/*--Funcionalidades sólo para Admin--*/
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("")
	public ResponseEntity<List<PlayerDto>> listPlayers(){
		List<PlayerDto> playersDto = playerService.getAllPlayers();
		if (playersDto.isEmpty()) {

			log.info("No hay Jugadores en el sistema.");
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(playersDto, HttpStatus.OK);
	}

	@PostMapping("/add-admin-role")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addAdminRoleToUser(@RequestParam String id) {
		PlayerDto playerDto = playerService.addAdminRole(id);
		if(playerDto == null){
			return new ResponseEntity<>("NO hay jugadores con id: "+id, HttpStatus.NOT_FOUND);
		}
		log.info("Admin Role agregado para usuario {} ", playerDto.getUserName());
		return new ResponseEntity<>(playerDto, HttpStatus.OK);
	}

	@GetMapping("/all-admins")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> listAdmins() {
		List<PlayerDto> playersDto = playerService.getAllAdmins();
		if (playersDto.isEmpty()) {
			log.info("No hay Admins en el sistema.");
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(playersDto, HttpStatus.OK);

	}


}
