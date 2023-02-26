package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.GameDto;

public interface IGameService {
	
	GameDto newGame(int id);
	
	boolean deleteAllGamesByPlayerId(int id);

}
