package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import java.util.List;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;

public interface IPlayerService {
	
	List<PlayerDto> getAllPlayers();

	PlayerDto findPlayerById(int id) throws Exception;

	PlayerDto register(String nombre);
	

}
