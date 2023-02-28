package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ita.S05T02N01JanotaFuenteGuido.dados.model.converter.EntityDtoConverter;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.GameDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IPlayerRepository;

@Service
public class GameServiceImpl implements IGameService {

	@Autowired
	private IPlayerRepository playerRepository;
	
//	@Autowired
//	private IGameRepository gameRepository;
//	
	@Autowired
	private EntityDtoConverter converter;
	
	
	@Override
	public GameDto newGame(String id) {
		Optional<Player> oPlayer = playerRepository.findById(id);
		if (oPlayer.isEmpty()) {
			return null;
		}
		Player player = oPlayer.get();
		Game game = new Game();

		//Si gana la partida se agrega a las victorias del jugador
		if (game.isWin()) {
			player.setVictories(player.getVictories()+1);
		}
		//Actualiza porcentaje de partidas ganadas
		player.updateWinSuccess();
		player.getGames().add(game);
		playerRepository.save(player);
	
		return converter.toGameDto(game);
				
		
	}
	

//	@Override
//	public boolean deleteAllGamesByPlayerId(String id) {
//		boolean deleted=false;
//		Optional<Player> oPlayer= playerRepository.findById(id);
//		
//		if(oPlayer.isPresent()) {
//			Player player = oPlayer.get();
//			player.setVictories(0);
//			player.setWinSuccess(0);
//			
//			//Crea una lista con todas las partidas para poder obtener el Id de cada una
//			List<Game> playerGames = player.getGames();
//			
//			//Itera para borrar por Id
//			playerGames.forEach( x-> gameRepository.deleteById(x.getId()) );
//			deleted =true;
//		}
//		return deleted;	
//	}
	


}
