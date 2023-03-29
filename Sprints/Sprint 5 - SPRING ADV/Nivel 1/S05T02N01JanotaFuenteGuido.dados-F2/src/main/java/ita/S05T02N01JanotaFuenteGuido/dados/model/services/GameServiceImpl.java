package ita.S05T02N01JanotaFuenteGuido.dados.model.services;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ita.S05T02N01JanotaFuenteGuido.dados.utils.mapper.EntityDtoMapper;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.GameDto;
//import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IGameRepository;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IPlayerRepository;

@Service
public class GameServiceImpl implements IGameService {

	@Autowired
	private IPlayerRepository playerRepository;
	
	@Autowired
	private EntityDtoMapper entityDtoMapper;
	

	@Override
	public GameDto newGame(String id) {
		Optional<Player> oPlayer = playerRepository.findById(id);
		if (oPlayer.isEmpty()) {
			return null;
		}
		Player player = oPlayer.get();
		Game game = new Game();

		//Si gana la partida se agrega a las victorias del jugador
		if (game.isWin()) {
			player.setVictories(player.getVictories()+1);
		}
		//Actualiza porcentaje de partidas ganadas
		player.updateWinSuccess();
		
		//Guarda
		player.getGames().add(game);	
		playerRepository.save(player);
		
		return entityDtoMapper.toGameDto(game);
	}

	@Override
	public boolean deleteAllGamesByPlayerId(String id) {
		Optional<Player> oPlayer= playerRepository.findById(id);
		if(oPlayer.isPresent()) {
			Player player = oPlayer.get();
			player.resetPlayer();
			playerRepository.save(player);
			return true;
		}
		return false;
	}

}
