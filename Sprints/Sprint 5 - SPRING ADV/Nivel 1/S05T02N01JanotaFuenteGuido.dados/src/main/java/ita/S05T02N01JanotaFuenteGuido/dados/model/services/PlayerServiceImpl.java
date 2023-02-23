package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ita.S05T02N01JanotaFuenteGuido.dados.model.converter.EntityDtoConverter;
import ita.S05T02N01JanotaFuenteGuido.dados.model.converter.PlayerConverter;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IPlayerRepository;

@SuppressWarnings("unused")
@Service
public class PlayerServiceImpl implements IPlayerService{

	@Autowired 
	private IPlayerRepository playerRepository;
	
	@Autowired
	private EntityDtoConverter converter;
	
	
//	@Override
//	public PlayerDto register(PlayerDto playerDto) {
//		playerRepository.save(converter.toPlayerEntity(playerDto));
//		return playerDto;
//	}
	
	@Override
	public PlayerDto register(String nombre) {
		Player player = new Player(nombre);
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
	public PlayerDto findPlayerById(int id) throws Exception {
		return converter.toPlayerDto(playerRepository.findById(id).orElse(null));
//		return playerConverter.entityToDto(playerRepository.findById(id).orElseThrow(() -> new Exception("No existe Usiario con id: " + id)));


	}

}
