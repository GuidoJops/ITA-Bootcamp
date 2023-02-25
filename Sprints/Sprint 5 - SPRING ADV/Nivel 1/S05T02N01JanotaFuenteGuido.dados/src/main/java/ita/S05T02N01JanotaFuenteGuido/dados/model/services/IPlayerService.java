package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import java.util.List;
import java.util.Map;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;

public interface IPlayerService {
	
	List<PlayerDto> getAllPlayers();

	PlayerDto findPlayerById(int id) throws Exception;

	PlayerDto register(String nombre);

	PlayerDto changeName(PlayerDto playerDto);

	List<Game> gamesByPlayerId(int id);

	Map<String, Double> getAllPlayersRanking();

	PlayerDto getWinner();

	PlayerDto getLoser();
	

}
