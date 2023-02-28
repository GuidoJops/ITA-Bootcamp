package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import java.util.List;
import java.util.Map;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;

public interface IPlayerService {
	
	List<PlayerDto> getAllPlayers();

	PlayerDto registerPlayer(String nombre);

	PlayerDto changePlayerName(PlayerDto playerDto);

	Map<String, Double> getAllPlayersRanking();

	PlayerDto getPlayerWinner();

	PlayerDto getPlayerLoser();

	PlayerDto findPlayerById(String id);

	List<Game> getGamesByPlayerId(String id);
	

}
