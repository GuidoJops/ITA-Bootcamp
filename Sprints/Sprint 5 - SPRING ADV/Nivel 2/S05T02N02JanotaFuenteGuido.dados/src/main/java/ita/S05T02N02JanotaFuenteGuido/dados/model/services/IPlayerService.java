package ita.S05T02N02JanotaFuenteGuido.dados.model.services;

import java.util.List;
import java.util.Map;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.AuthRequest;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.PlayerDto;

public interface IPlayerService {
	List<PlayerDto> getAllPlayers();
	PlayerDto createPlayer(AuthRequest authRequest);
	Map<String, Double> getAllPlayersRanking();
	PlayerDto getPlayerWinner();
	PlayerDto getPlayerLoser();
	PlayerDto findPlayerById(String id);
	List<Game> getGamesByPlayerId(String id);
	boolean playerExist(String userName);
	PlayerDto changePlayerName(String id, String Name);
	PlayerDto addAdminRole(String id);
	List<PlayerDto> getAllAdmins();

}
