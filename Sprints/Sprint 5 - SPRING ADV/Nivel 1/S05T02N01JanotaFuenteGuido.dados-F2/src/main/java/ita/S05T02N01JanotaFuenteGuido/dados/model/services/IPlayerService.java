package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import java.util.List;
import java.util.Map;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;

public interface IPlayerService {
	
	List<PlayerDto> getAllPlayers();

	//PlayerDto registerPlayer(String nombre);

	//No puede haber Jugadores con el nombre repetido pero SI puede haber muchos jugadores con
	//el nombre por defecto("NoNamePlayer")
	PlayerDto registerPlayer(String name, String UserName, String password);

	PlayerDto changePlayerName(PlayerDto playerDto);

	Map<String, Double> getAllPlayersRanking();

	PlayerDto getPlayerWinner();

	PlayerDto getPlayerLoser();

	PlayerDto findPlayerById(String id);

	List<Game> getGamesByPlayerId(String id);
	

}
