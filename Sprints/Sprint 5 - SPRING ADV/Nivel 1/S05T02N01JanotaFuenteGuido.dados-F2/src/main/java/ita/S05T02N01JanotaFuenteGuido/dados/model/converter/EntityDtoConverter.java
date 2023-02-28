package ita.S05T02N01JanotaFuenteGuido.dados.model.converter;

import org.springframework.stereotype.Component;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.GameDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;

@Component
public class EntityDtoConverter {
	
//----PLAYER----
		
	public PlayerDto toPlayerDto(Player player) {
		PlayerDto playerDto = new PlayerDto();

		playerDto.setId(player.getId());
		playerDto.setName(player.getName());
		playerDto.setRegistDate(player.getRegistDate());
		playerDto.setWinSuccess(player.getWinSuccess());

		System.out.println("Devolviendo PlayerDTO...");
		return playerDto;

	}

//----GAME----
	
	public GameDto toGameDto(Game game) {
		GameDto gameDto = new GameDto();

//		gameDto.setId(game.getId());
		gameDto.setDiceA(game.getDiceA());
		gameDto.setDiceB(game.getDiceB());
		gameDto.setWin(game.isWin());

		System.out.println("Devolviendo GameDTO...");
		return gameDto;
	}

	
	
}
