package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import java.util.List;
import java.util.Map;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;

public interface IPlayerService {
	
	List<PlayerDto> getAllPlayers();

	PlayerDto findPlayerById(int id);

	PlayerDto registerPlayer(String nombre);

	PlayerDto changePlayerName(PlayerDto playerDto);

	List<Game> getGamesByPlayerId(int id);

	Map<String, Double> getAllPlayersRanking();

	PlayerDto getPlayerWinner();

	PlayerDto getPlayerLoser();
	

}
