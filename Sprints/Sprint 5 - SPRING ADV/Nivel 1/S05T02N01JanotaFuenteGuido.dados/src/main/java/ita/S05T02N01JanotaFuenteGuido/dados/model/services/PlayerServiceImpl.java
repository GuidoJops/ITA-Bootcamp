package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ita.S05T02N01JanotaFuenteGuido.dados.model.converter.EntityDtoConverter;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IPlayerRepository;


@Service
public class PlayerServiceImpl implements IPlayerService{

	@Autowired 
	private IPlayerRepository playerRepository;
	
	@Autowired
	private EntityDtoConverter converter;
	
	
	@Override
	public PlayerDto register(String name) {
		Optional<Player> oPlayer = playerRepository.findByName(name);
		if(oPlayer.isPresent()) {
			return null;
		}
		Player player = new Player(name);
		return converter.toPlayerDto(playerRepository.save(player));
	}
	
	@Override
	public PlayerDto changeName(PlayerDto playerDto) {
		Optional<Player> oPlayer = playerRepository.findById(playerDto.getId());
		if(oPlayer.isEmpty()) {
			return null;
		}
		Player player = oPlayer.get();
		player.setName(playerDto.getName());
		return converter.toPlayerDto(playerRepository.save(player));
	}

	@Override
	public List<PlayerDto> getAllPlayers() {
		//Crea una lista de Dtos con las Entidades y las retorna
		return playerRepository.findAll()
				.stream()
				.map(player -> converter.toPlayerDto(player))
				.collect(Collectors.toList());
	
	}

	@Override
	//CHEQUEAR EL 'throws Exception'
	public PlayerDto findPlayerById(int id) throws Exception {
		return converter.toPlayerDto(playerRepository.findById(id).orElse(null));
//		return playerConverter.entityToDto(playerRepository.findById(id).orElseThrow(() -> new Exception("No existe Usiario con id: " + id)));


	}

	@Override
	public List<Game> gamesByPlayerId (int id){
		Optional <Player> oPlayer =  playerRepository.findById(id);
		if(oPlayer.isEmpty()) {
			return null;

		}
//		PlayerDto playerDto = converter.toPlayerDto (oPlayer.get());
//		return playerDto.getGames();
		
		Player player = oPlayer.get();
		return player.getGames();
	}

	
	@Override
	public Map<String, Double> getAllPlayersRanking() {
		List<PlayerDto> playersDto = getAllPlayers();
		return playersDto.stream()
				.sorted(Comparator.comparing(PlayerDto::getWinSuccess) //Ordena el Map segun valor
						.reversed())								// en orden mayor a menor
				.collect(Collectors.toMap(PlayerDto::getName, PlayerDto::getWinSuccess,
						(e1, e2) -> e2, LinkedHashMap::new));	// Toma los datos del sorted()
	}
	
	//CONTEMPLAR SI HAY MAS DE UNO??
	@Override
	public PlayerDto getWinner() {
		List<PlayerDto> playersDto = getAllPlayers();
		return playersDto.stream()
				.max(Comparator.comparing(PlayerDto::getWinSuccess))
				.get();
	}
	
	//CONTEMPLAR SI HAY MAS DE UNO??
	@Override
	public PlayerDto getLoser() {
		List<PlayerDto> playersDto = getAllPlayers();
		return playersDto.stream()
				.min(Comparator.comparing(PlayerDto::getWinSuccess))
				.get();
	}
	
	
	
	
}
