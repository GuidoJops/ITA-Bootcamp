package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ita.S05T02N01JanotaFuenteGuido.dados.model.converter.EntityDtoConverter;
import ita.S05T02N01JanotaFuenteGuido.dados.model.converter.GameConverter;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.GameDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IGameRepository;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IPlayerRepository;

@Service
public class GameServiceImpl implements IGameService {

	@Autowired
	private IPlayerRepository playerRepository;
	
	@Autowired
	private IGameRepository gameRepository;
	
	@Autowired
	private IPlayerService playerService;
	
	@Autowired
	private EntityDtoConverter converter;
	
	
	@Override
	public GameDto newGame(int id) {
		Player player = playerRepository.findById(id).get();
		if (player==null) {
			return null;
		}
		
		Game game = new Game(player);
		//Guarda el 'game' y se actualiza la 'Lista de Games' en la tabla 'Players'
		//gracias a CascadeType.PERSIST en entidad GAME
		return converter.toGameDto(gameRepository.save(game));
				
		
	}


	@Override
	public boolean deleteAllGames(int id) {
		boolean deleted=false;
		Optional<Player> oPlayer= playerRepository.findById(id);
		if(oPlayer.isEmpty()) {
			return deleted;
		}
		//Se crea una lista con todas las partidas para poder obtener el Id de cada una
		List<Game> playerGames = oPlayer.get().getGames();
		//Se itera para borrar por Id
		playerGames.stream().forEach( x-> gameRepository.deleteById(x.getId()));

		//OTRA OPCION
//		for (Game o : playerGames){
//		gameRepository.deleteById(o.getId());
//}
		
//		//SE PODRÁ HACER ALGO ASI??
//		Player player = oPlayer.get();
//		player.setGames(new ArrayList<Game>());
//		playerRepository.save(player);
		return deleted=true;
	}
	


}
