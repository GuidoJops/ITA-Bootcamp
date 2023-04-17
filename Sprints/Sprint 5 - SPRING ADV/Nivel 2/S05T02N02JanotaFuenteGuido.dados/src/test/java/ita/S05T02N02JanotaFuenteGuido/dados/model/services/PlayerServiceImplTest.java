package ita.S05T02N02JanotaFuenteGuido.dados.model.services;

import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.ERole;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Role;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.AuthRequest;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N02JanotaFuenteGuido.dados.model.repository.IPlayerRepository;
import ita.S05T02N02JanotaFuenteGuido.dados.model.repository.IRoleRepository;
import ita.S05T02N02JanotaFuenteGuido.dados.model.services.impl.PlayerServiceImpl;
import ita.S05T02N02JanotaFuenteGuido.dados.utils.mapper.EntityDtoMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceImplTest {

    @Mock private IPlayerRepository playerRepository;
    @Mock private PasswordEncoder passwordEncoder;
    @Mock private IRoleRepository roleRepository;
    @Mock private EntityDtoMapper entityDtoMapper;

    @InjectMocks private PlayerServiceImpl playerService;


    @Test
    void shouldCreatePlayer() {
        //given
        AuthRequest authRequest = AuthRequest.builder()
                .name("testName")
                .userName("test@gmail.com")
                .password("testpswd")
                .build();

        //when
//        Mockito.when(playerRepository.save(Mockito.any(Player.class))).thenReturn(player);
//        Mockito.when(entityDtoMapper.toPlayerDto(Mockito.any(Player.class))).thenReturn(playerDto);
        Mockito.when(playerRepository.save(Mockito.any(Player.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));
        Mockito.when(entityDtoMapper.toPlayerDto(Mockito.any(Player.class)))
                .thenAnswer(invocation -> {
                    Player player = invocation.getArgument(0);
                    return PlayerDto.builder()
                            .name(player.getName())
                            .userName(player.getUserName())
                            .build();
                });

        PlayerDto result = playerService.createPlayer(authRequest);

        //then
        Mockito.verify(playerRepository, times(1)).save(Mockito.any(Player.class));
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getName()).isEqualTo(authRequest.getName());

    }

    @Test
    void shouldChangePlayerName() {
        //given
        String newName = "newName";
        Player player = Player.builder()
                .id("id")
                .name("testName")
                .build();

//        PlayerDto playerDto = PlayerDto.builder()
//                .id(player.getId())
//                .name(player.getName())
//                .build();

        //when
        Mockito.when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));
//        Mockito.when(entityDtoMapper.toPlayerDto(Mockito.any(Player.class))).thenReturn(playerDto);
        Mockito.when(entityDtoMapper.toPlayerDto(Mockito.any(Player.class)))
                .thenAnswer(invocation -> {
                    Player invPlayer = invocation.getArgument(0);
                    return PlayerDto.builder()
                            .id(invPlayer.getId())
                            .name(invPlayer.getName())
                            .build();
                });
        Mockito.when(playerRepository.save(Mockito.any(Player.class))).thenReturn(player);
        PlayerDto result = playerService.changePlayerName(player.getId(), newName);

        //then
        Mockito.verify(playerRepository, times(1)).save(Mockito.any(Player.class));
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getId()).isEqualTo(player.getId());
        Assertions.assertThat(result.getName()).isEqualTo(newName);
    }

    @Test
    void shouldNotChangePlayerName_returnsNull() {
        //given
        String id = "testID1";
        String name = "testName";
        //when
        Mockito.when(playerRepository.findById(id)).thenReturn(Optional.empty());
        PlayerDto result = playerService.changePlayerName(id, name);
        //then
        Mockito.verify(playerRepository, never()).save(Mockito.any(Player.class));
        Assertions.assertThat(result).isNull();
    }

    @Test
    void shouldAddAdminRole() {
        //given
        List<Role> roles = new ArrayList<>();
        Role roleUser = new Role (2L, ERole.ROLE_USER);
        Role roleAdmin = new Role ( 1L, ERole.ROLE_ADMIN );

        roles.add(roleUser);

        Player player1 = Player.builder()
                .id("id")
                .roles(roles)
                .build();

        //when
        Mockito.when(playerRepository.findById(player1.getId())).thenReturn(Optional.of(player1));
        Mockito.when(roleRepository.findByType(ERole.ROLE_ADMIN)).thenReturn(Optional.of(roleAdmin));
        Mockito.when(entityDtoMapper.toPlayerDto(Mockito.any(Player.class))).thenReturn(new PlayerDto());
        Mockito.when(playerRepository.save(Mockito.any(Player.class))).thenReturn(player1);
        PlayerDto result = playerService.addAdminRole(player1.getId());

        //then
        Mockito.verify(playerRepository, times(1)).save(Mockito.any(Player.class));
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(player1.getRoles().size()).isEqualTo(2);
        Assertions.assertThat(player1.getRoles().get(1).getType()).isEqualTo(ERole.ROLE_ADMIN);
    }

    @Test
    void shouldNotAddAdminRole_returnsNull() {
        //given
        String id = "testID1";
        Role role = new Role ( 1L, ERole.ROLE_ADMIN );

        //when
        Mockito.when(playerRepository.findById(id)).thenReturn(Optional.empty());
        PlayerDto result = playerService.addAdminRole(id);

        //then
        Mockito.verify(playerRepository, never()).save(Mockito.any(Player.class));
        Assertions.assertThat(result).isNull();

    }

    @Test
    void shouldGetAllAdmins() {
        //given
        Player playerAdmin1 =Player.builder()
                .roles(Arrays.asList(new Role(1L, ERole.ROLE_ADMIN)))
                .build();

        Player playerAdmin2 =Player.builder()
                .roles(Arrays.asList(new Role(1L, ERole.ROLE_ADMIN)))
                .build();

        Player playerUser =Player.builder()
                .roles(Arrays.asList(new Role(2L, ERole.ROLE_USER)))
                .build();


        //when
        Mockito.when(playerRepository.findAll()).thenReturn(List.of(playerAdmin1, playerAdmin2, playerUser));
        Mockito.when(entityDtoMapper.toPlayerDto(Mockito.any(Player.class))).thenReturn(new PlayerDto());

        List<PlayerDto> result = playerService.getAllAdmins();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);

    }

    @Test
    void shouldGetAllPlayers() {
        //given
        Player player2 =Player.builder()
                .name("testName")
                .build();

        Player playerDefaultAdmin = Player.builder()
                .name("DEFAULT-ADMIN")
                .build();

        //when
        Mockito.when(playerRepository.findAll()).thenReturn(List.of(player2, playerDefaultAdmin));
        Mockito.when(entityDtoMapper.toPlayerDto(Mockito.any(Player.class))).thenReturn(new PlayerDto());

        List<PlayerDto> result = playerService.getAllPlayers();

        //then
        Assertions.assertThat(result.size()).isEqualTo(1);

    }

    @Test
    void shouldFindPlayerById() {
        //given
        String id = "id";

        //when
        Mockito.when(playerRepository.findById(id)).thenReturn(Optional.of(new Player()));
        Mockito.when(entityDtoMapper.toPlayerDto(Mockito.any(Player.class))).thenReturn(new PlayerDto());

        PlayerDto result = playerService.findPlayerById(id);

        //then
        Assertions.assertThat(result).isNotNull();
    }

    @Test
    void shouldNotFindPlayerById_returnsNull() {
        //given
        String id = "id";

        //when
        Mockito.when(playerRepository.findById(id)).thenReturn(Optional.empty());
        PlayerDto result = playerService.findPlayerById(id);

        //then
        Assertions.assertThat(result).isNull();
    }

    @Test
    void shouldGetGamesByPlayerId() {
        //given
        Player player = Player.builder()
                .id("id")
                .games(Arrays.asList(new Game(), new Game()))
                .build();

        //when
        Mockito.when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));
        List<Game> result = playerService.getGamesByPlayerId(player.getId());

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void shouldNotGetGamesByPlayerId_returnsNull() {
        //given
        String id = "id";

        //when
        Mockito.when(playerRepository.findById(id)).thenReturn(Optional.empty());
        List<Game> result = playerService.getGamesByPlayerId(id);

        //then
        Assertions.assertThat(result).isNull();
    }

    @DisplayName("shouldGetAllPlayersRanking filtering names: 'NoNamePlayer', 'DEFAULT-ADMIN' ")
    @Test
    void shouldGetAllPlayersRanking() {
        //given
        Player player = Player.builder()
                .name("name1")
                .userName("user")
                .winSuccess(10)
                .build();

        Player player2 = Player.builder()
                .name("name2")
                .userName("user2")
                .winSuccess(20)
                .build();

        Player player3 = Player.builder()
                .name("name3")
                .userName("user3")
                .winSuccess(30)
                .build();

        Player player4 = Player.builder()
                .name("NoNamePlayer")
                .userName("user4")
                .winSuccess(70)
                .build();

        Player playerDefaultAdmin = Player.builder()
                .name("DEFAULT-ADMIN")
                .userName("admin")
                .build();

        //when
        Mockito.when(playerRepository.findAll()).thenReturn(List.of(player, player2, player3, player4, playerDefaultAdmin));
        Map<String, Double> result = playerService.getAllPlayersRanking();

        //then
        Assertions.assertThat(result.size()).isEqualTo(3);
        Assertions.assertThat(result.get(player3.getUserName())).isGreaterThan(result.get(player2.getUserName()));
        Assertions.assertThat(result.get(player2.getUserName())).isGreaterThan(result.get(player.getUserName()));


    }

    @DisplayName("shouldGetPlayerWinner filtering names: 'NoNamePlayer', 'DEFAULT-ADMIN' ")
    @Test
    void shouldGetPlayerWinner() {
        //given
        Player player2 = Player.builder()
                .name("test2")
                .winSuccess(60)
                .build();
        Player player3 = Player.builder()
                .name("test3")
                .winSuccess(10)
                .build();
        Player playerNoName = Player.builder()
                .name("NoNamePlayer")
                .winSuccess(90)
                .build();
        Player playerAdmin = Player.builder()
                .name("DEFAULT-ADMIN")
                .winSuccess(70)
                .build();

        //when
        Mockito.when(playerRepository.findAll()).thenReturn(List.of(player2, player3, playerNoName, playerAdmin));
        Mockito.when(entityDtoMapper.toPlayerDto(Mockito.any(Player.class)))
                .thenAnswer(invocation -> {
                    Player player = invocation.getArgument(0);
                    return PlayerDto.builder()
                            .name(player.getName())
                            .build();
                });

        PlayerDto result = playerService.getPlayerWinner();

        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getName()).isEqualTo(player2.getName());
    }

    @Test
    void shouldNotGetPlayerWinner_returnsNull() {
        //given
        //when
        Mockito.when(playerRepository.findAll()).thenReturn(Collections.emptyList());
        PlayerDto result = playerService.getPlayerWinner();

        //then
        Assertions.assertThat(result).isNull();
    }

    @DisplayName("shouldGetPlayerLoser filtering names: 'NoNamePlayer', 'DEFAULT-ADMIN' ")
    @Test
    void shouldGetPlayerLoser() {
        //given
        Player player2 = Player.builder()
                .name("test2")
                .winSuccess(60)
                .build();
        Player player3 = Player.builder()
                .name("test3")
                .winSuccess(10)
                .build();
        Player playerNoName = Player.builder()
                .name("NoNamePlayer")
                .winSuccess(90)
                .build();
        Player playerAdmin = Player.builder()
                .name("DEFAULT-ADMIN")
                .winSuccess(70)
                .build();

        //when
        Mockito.when(playerRepository.findAll()).thenReturn(List.of(player2, player3, playerNoName, playerAdmin));
        Mockito.when(entityDtoMapper.toPlayerDto(Mockito.any(Player.class)))
                .thenAnswer(invocation -> {
                    Player player = invocation.getArgument(0);
                    return PlayerDto.builder()
                            .name(player.getName())
                            .build();
                });
        PlayerDto result = playerService.getPlayerLoser();

        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getName()).isEqualTo(player3.getName());
    }

    @Test
    void shouldNotGetPlayerLoser_returnsNull() {
        //given
        //when
        Mockito.when(playerRepository.findAll()).thenReturn(Collections.emptyList());
        PlayerDto result = playerService.getPlayerLoser();

        //then
        Assertions.assertThat(result).isNull();
    }

    @Test
    void shouldReturnTrue_PlayerExist() {
        //given
        String userName = "testUserName";

        //when
        Mockito.when(playerRepository.existsByUserName(userName)).thenReturn(true);
        boolean result = playerService.playerExist(userName);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }
}