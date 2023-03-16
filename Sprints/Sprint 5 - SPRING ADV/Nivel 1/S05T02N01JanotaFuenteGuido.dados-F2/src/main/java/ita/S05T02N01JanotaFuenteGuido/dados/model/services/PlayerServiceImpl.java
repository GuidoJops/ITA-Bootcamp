package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.ERole;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Role;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.UserDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ita.S05T02N01JanotaFuenteGuido.dados.model.converter.EntityDtoConverter;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IPlayerRepository;

@Slf4j
@Service
public class PlayerServiceImpl implements IPlayerService{

	@Autowired 
	private IPlayerRepository playerRepository;
	@Autowired
	private EntityDtoConverter converter;
	@Autowired
	private IRoleRepository roleRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;

	//No puede haber Jugadores con el nombre repetido pero SI puede haber muchos jugadores con
	//el nombre por defecto("NoNamePlayer")
	@Override
	public PlayerDto registerPlayer(String name, String UserName, String password) {
		Optional<Player> oPlayer = playerRepository.findByName(name).stream().findFirst();
		if(oPlayer.isPresent() && !(oPlayer.get().getName().equalsIgnoreCase("NoNamePlayer"))) {
			return null;
		}
//		Player player = new Player(name, UserName, securityConfig.passwordEncoder().encode(password));

//		return converter.toPlayerDto(playerRepository.save(player));
		return null;
	}
	
	@Override
	public PlayerDto changePlayerName(PlayerDto playerDto) {
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
		//Crea una lista de PlayerDtos a partir de las Entidades y los retorna
		return playerRepository.findAll()
				.stream()
				.map(player -> converter.toPlayerDto(player))
				.collect(Collectors.toList());
	
	}

	@Override
	public PlayerDto findPlayerById(String id) {
		return converter.toPlayerDto(playerRepository.findById(id).orElse(null));

	}

	@Override
	public List<Game> getGamesByPlayerId (String id){
		Optional <Player> oPlayer =  playerRepository.findById(id);
		if(oPlayer.isEmpty()) {
			return null;
		}
		Player player = oPlayer.get();
		
		return player.getGames();
	}

	//Tiene en cuenta solo Jugadores registrados con nombre. Excluye los 'NoNamePLayer'
	@Override
	public Map<String, Double> getAllPlayersRanking() {
    	//LinkedHashMap garantiza el orden en el que insertan los datos
        Map<String, Double> rankingMap = new LinkedHashMap<>();
        
        //Ordenados de mayor a menor segun el porcentaje de exito
        List<Player> players = playerRepository.findAll().stream()
        		.filter(Predicate.not(p->p.getName().equalsIgnoreCase("NoNamePlayer")))
                .sorted(Comparator.comparing(Player::getWinSuccess).reversed())
                .collect(Collectors.toList());
        //Inserta en el MAP los jugadores ordenados   
        players.forEach(p -> rankingMap.put(p.getName(), p.getWinSuccess()));
        
        return rankingMap;
       
    }
		
	//Tiene en cuenta solo Jugadores registrados con nombre. Excluye los 'NoNamePLayer'
	@Override
	public PlayerDto getPlayerWinner() {
		List<Player> players = playerRepository.findAll();
		if (players.isEmpty()) {
			return null;
		}
		Optional<Player> oPlayer = players.stream()
				.filter(Predicate.not(p->p.getName().equalsIgnoreCase("NoNamePlayer")))
				.max(Comparator.comparing(Player::getWinSuccess));
		
		return converter.toPlayerDto(oPlayer.get());
	}

	//Tiene en cuenta solo Jugadores registrados con nombre. Excluye los 'NoNamePLayer'
	@Override
	public PlayerDto getPlayerLoser() {
		List<Player> players = playerRepository.findAll();
		if (players.isEmpty()) {
			return null;
		}
		Optional<Player> oPlayer = players.stream()
				.filter(Predicate.not(p->p.getName().equalsIgnoreCase("NoNamePlayer")))
				.min(Comparator.comparing(Player::getWinSuccess));
		
		return converter.toPlayerDto(oPlayer.get());
	
	}
	
	
}
