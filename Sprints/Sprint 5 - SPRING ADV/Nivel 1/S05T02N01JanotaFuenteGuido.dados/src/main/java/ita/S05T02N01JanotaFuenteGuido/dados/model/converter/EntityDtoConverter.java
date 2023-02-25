package ita.S05T02N01JanotaFuenteGuido.dados.model.converter;

import org.springframework.stereotype.Component;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.GameDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;

@Component
public class EntityDtoConverter {
	
//----PLAYER----

	public Player toPlayerEntity(PlayerDto playerDto) {
		Player player = new Player(playerDto.getName());
		
		player.setId(playerDto.getId());
		player.setRegistDate(playerDto.getRegistDate());
		player.setWinSuccess(playerDto.getWinSuccess());
//		player.setGames(playerDto.getGames());
		
		System.out.println("Devolviendo PlayerEntidad...");
		return player;
		
	}

	
	public PlayerDto toPlayerDto(Player player) {
		if(player !=null) { //CHEQUEAR SI SIRVE DE ALGO
			PlayerDto playerDto = new PlayerDto();
			
			playerDto.setId(player.getId());
			playerDto.setName(player.getName());
			playerDto.setRegistDate(player.getRegistDate());
			playerDto.setWinSuccess(player.getWinSuccess());
//			playerDto.setGames(player.getGames());

			
			System.out.println("Devolviendo PlayerDTO...");
			return playerDto;
		}
		
		
		return null;
	}
	
	
	
//----GAME----
	
	public GameDto toGameDto(Game game) {
		if(game !=null) {  //CHEQUEAR SI SIRVE DE ALGO
			GameDto gameDto = new GameDto();
			
			gameDto.setId(game.getId());
			gameDto.setDiceA(game.getDiceA());
			gameDto.setDiceB(game.getDiceB());
			gameDto.setWin(game.getWin());
			
			System.out.println("Devolviendo GameDTO...");
			return gameDto;
		}
		
		
		return null;
	}
	
	
	public Game toGameEntity(GameDto gameDto) {
		Game game = new Game();
		
		game.setId(gameDto.getId());
		game.setDiceA(gameDto.getDiceA());
		game.setDiceB(gameDto.getDiceB());
		game.setWin(gameDto.getWin());
//		game.setPlayer(gameDto.getPlayer());

		System.out.println("Devolviendo GameEntidad...");
		return game;
		
	}

}
