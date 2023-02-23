package ita.S05T02N01JanotaFuenteGuido.dados.model.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.GameDto;

@Component
public class GameConverter {

	private Game game;
	private GameDto gameDto;
	
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameDto getGameDto() {
		return gameDto;
	}

	public void setGameDto(GameDto gameDto) {
		this.gameDto = gameDto;
	}

	
	
	public GameDto entityToDto(Game game) {
		if(game !=null) {
			GameDto gameDto = new GameDto();
			
			gameDto.setId(game.getId());
			gameDto.setDiceA(game.getDiceA());
			gameDto.setDiceB(game.getDiceB());
			gameDto.setWin(game.getWin());
//			gameDto.setPlayer(game.getPlayer());
			
			System.out.println("Devolviendo DTO...");
			
			return gameDto;
		}
		
		
		return null;
	}
	
	public List<GameDto> entityToDto(List<Game> listEntity){
		System.out.println("Devolviendo Lista DTO...");

		return listEntity.stream().map(x-> entityToDto(x)).toList();
	}
	
	public Game dtoToEntity(GameDto gameDto) {
		Game game = new Game();
		
		game.setId(gameDto.getId());
		game.setDiceA(gameDto.getDiceA());
		game.setDiceB(gameDto.getDiceB());
		game.setWin(gameDto.getWin());
//		game.setPlayer(gameDto.getPlayer());

		
		System.out.println("Devolviendo Entidad...");

		return game;
		
	}
	
}
