package ita.S05T02N01JanotaFuenteGuido.dados.model.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;

@Component
public class PlayerConverter {

	private Player player;
	private PlayerDto playerDto;
	
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public PlayerDto getPlayerDto() {
		return playerDto;
	}

	public void setPlayerDto(PlayerDto playerDto) {
		this.playerDto = playerDto;
	}

	
	
	public PlayerDto entityToDto(Player player) {
		if(player !=null) {
			PlayerDto playerDto = new PlayerDto();
			
			playerDto.setId(player.getId());
			playerDto.setName(player.getName());
			playerDto.setRegistDate(player.getRegistDate());
			playerDto.setWinSuccess(player.getWinSuccess());
			playerDto.setGames(player.getGames());

			
			System.out.println("Devolviendo DTO...");
			
			return playerDto;
		}
		
		
		return null;
	}
	
	public List<PlayerDto> entityToDto(List<Player> listEntity){
		System.out.println("Devolviendo Lista DTO...");

		return listEntity.stream().map(x-> entityToDto(x)).toList();
	}
	
	
	public Player dtoToEntity(PlayerDto playerDto) {
		Player player = new Player();
		
		player.setId(playerDto.getId());
		player.setName(playerDto.getName());
		player.setRegistDate(playerDto.getRegistDate());
		player.setWinSuccess(playerDto.getWinSuccess());
		player.setGames(playerDto.getGames());
		
		System.out.println("Devolviendo Entidad...");

		return player;
		
	}
	
}
