package ita.S05T02N02JanotaFuenteGuido.dados.utils.mapper;

import org.springframework.stereotype.Component;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.GameDto;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.PlayerDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EntityDtoMapper {

	//----PLAYER----
	public PlayerDto toPlayerDto(Player player) {
		PlayerDto playerDto = new PlayerDto();

		playerDto.setId(player.getId());
		playerDto.setName(player.getName());
		playerDto.setUserName(player.getUserName());
		playerDto.setRegistDate(player.getRegistDate());
		playerDto.setWinSuccess(player.getWinSuccess());

//		log.info("Devolviendo PlayerDto...");
		return playerDto;

	}

//----GAME----
	public GameDto toGameDto(Game game) {
		GameDto gameDto = new GameDto();

		gameDto.setDiceA(game.getDiceA());
		gameDto.setDiceB(game.getDiceB());
		gameDto.setWin(game.isWin());

//		log.info("Devolviendo GameDTO...");
		return gameDto;
	}
	
}
