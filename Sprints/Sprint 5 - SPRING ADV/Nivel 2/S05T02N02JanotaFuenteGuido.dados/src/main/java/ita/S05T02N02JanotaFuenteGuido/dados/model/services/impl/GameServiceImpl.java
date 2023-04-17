package ita.S05T02N02JanotaFuenteGuido.dados.model.services.impl;


import java.util.Optional;

import ita.S05T02N02JanotaFuenteGuido.dados.model.services.IGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import ita.S05T02N02JanotaFuenteGuido.dados.utils.mapper.EntityDtoMapper;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.GameDto;
import ita.S05T02N02JanotaFuenteGuido.dados.model.repository.IPlayerRepository;

@Slf4j
@Service
public class GameServiceImpl implements IGameService {

	private final IPlayerRepository playerRepository;
	private final EntityDtoMapper entityDtoMapper;

	public GameServiceImpl(IPlayerRepository playerRepository, EntityDtoMapper entityDtoMapper) {
		this.playerRepository = playerRepository;
		this.entityDtoMapper = entityDtoMapper;
	}

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
			player.setVictories(player.getVictories() + 1);
		}
		//Actualiza porcentaje de partidas ganadas
		player.updateWinSuccess();
		
		//Guarda
		player.getGames().add(game);	
		playerRepository.save(player);
		log.info("Usuario {} jugó una partida", player.getUserName());
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
