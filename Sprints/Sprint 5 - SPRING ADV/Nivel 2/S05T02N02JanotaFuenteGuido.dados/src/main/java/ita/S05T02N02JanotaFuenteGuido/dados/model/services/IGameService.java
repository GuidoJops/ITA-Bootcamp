package ita.S05T02N02JanotaFuenteGuido.dados.model.services;

import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.GameDto;

public interface IGameService {
	
	boolean deleteAllGamesByPlayerId(String id);
	GameDto newGame(String id);

}
