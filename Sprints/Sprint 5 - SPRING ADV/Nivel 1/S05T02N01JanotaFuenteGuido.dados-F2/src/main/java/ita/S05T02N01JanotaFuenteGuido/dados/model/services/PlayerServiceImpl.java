package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.ERole;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Role;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.AuthRequest;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ita.S05T02N01JanotaFuenteGuido.dados.utils.mapper.EntityDtoMapper;
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
	private EntityDtoMapper entityDtoMapper;
	@Autowired
	private IRoleRepository roleRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public PlayerDto createPlayer(AuthRequest authRequest) {
		Player player = new Player(authRequest.getName(),
				authRequest.getUserName(),
				passwordEncoder.encode(authRequest.getPassword()));

		Role roles = roleRepository.findByType(ERole.ROLE_USER).get(); // role de USER por defecto
		player.setRoles(Collections.singletonList(roles));
		log.info("Player Creado");
		return entityDtoMapper.toPlayerDto(playerRepository.save(player));
	}

	@Override
	public PlayerDto changePlayerName(String id, String name) {
		Optional<Player> oPlayer = playerRepository.findById(id);
		if(oPlayer.isEmpty()) {
			return null;
		}
		Player player = oPlayer.get();
		player.setName(name);
		return entityDtoMapper.toPlayerDto(playerRepository.save(player));
	}

	@Override
	public PlayerDto addAdminRole(String id) {
		Optional <Player> oPlayer =  playerRepository.findById(id);
		if(oPlayer.isEmpty()) {
			return null;
		}
		Player player = oPlayer.get();
		List<Role> roles = player.getRoles();
		roles.add(roleRepository.findByType(ERole.ROLE_ADMIN).get());
		return entityDtoMapper.toPlayerDto(playerRepository.save(player));
	}

	//Crea una lista de PlayerDtos a partir de las Entidades, filtra 'Admins' y los retorna
	@Override
	public List<PlayerDto> getAllAdmins() {
		return playerRepository.findAll()
				.stream()
				.filter(player -> player.getRoles()
						.stream()
						.anyMatch(role -> role.getType() == ERole.ROLE_ADMIN))
				.map(player -> entityDtoMapper.toPlayerDto(player)).collect(Collectors.toList());
	}

	//Crea una lista de PlayerDtos a partir de las Entidades y los retorna
	@Override
	public List<PlayerDto> getAllPlayers() {
		return playerRepository.findAll()
				.stream()
				.filter(Predicate.not(p->p.getName().equals("DEFAULT-ADMIN")))
				.map(player -> entityDtoMapper.toPlayerDto(player))
				.collect(Collectors.toList());
	}

	@Override
	public PlayerDto findPlayerById(String id) {
		return entityDtoMapper.toPlayerDto(playerRepository.findById(id).orElse(null));
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

	//Tiene en cuenta solo Jugadores registrados CON nombre. Excluye los 'NoNamePLayer' y 'DEFAULT-ADMIN'
	@Override
	public Map<String, Double> getAllPlayersRanking() {
    	//LinkedHashMap garantiza el orden en el que insertan los datos
        Map<String, Double> rankingMap = new LinkedHashMap<>();
        
        //Ordenados de mayor a menor segun el porcentaje de exito
        List<Player> players = playerRepository.findAll().stream()
        		.filter(Predicate.not(p ->
						p.getName().equalsIgnoreCase("NoNamePlayer") ||
						p.getName().equalsIgnoreCase("DEFAULT-ADMIN")))
                .sorted(Comparator.comparing(Player::getWinSuccess).reversed())
                .collect(Collectors.toList());
        //Inserta en el MAP los jugadores ordenados   
        players.forEach(p -> rankingMap.put(p.getUserName(), p.getWinSuccess()));
        return rankingMap;
       
    }

	//Tiene en cuenta solo Jugadores registrados CON nombre. Excluye los 'NoNamePLayer' y 'DEFAULT-ADMIN'
	@Override
	public PlayerDto getPlayerWinner() {
		List<Player> players = playerRepository.findAll();
		if (players.isEmpty()) {
			return null;
		}
		Optional<Player> oPlayer = players.stream()
				.filter(Predicate.not(p ->
						p.getName().equalsIgnoreCase("NoNamePlayer") ||
						p.getName().equalsIgnoreCase("DEFAULT-ADMIN")))
				.max(Comparator.comparing(Player::getWinSuccess));
		
		return entityDtoMapper.toPlayerDto(oPlayer.get());
	}

	//Tiene en cuenta solo Jugadores registrados con nombre. Excluye los 'NoNamePLayer'
	@Override
	public PlayerDto getPlayerLoser() {
		List<Player> players = playerRepository.findAll();
		if (players.isEmpty()) {
			return null;
		}
		Optional<Player> oPlayer = players.stream()
				.filter(Predicate.not(p ->
						p.getName().equalsIgnoreCase("NoNamePlayer") ||
						p.getName().equalsIgnoreCase("DEFAULT-ADMIN")))
				.min(Comparator.comparing(Player::getWinSuccess));
		
		return entityDtoMapper.toPlayerDto(oPlayer.get());
	}

	@Override
	public boolean playerExist(String userName) {
		return playerRepository.existsByUserName(userName);
	}

}
