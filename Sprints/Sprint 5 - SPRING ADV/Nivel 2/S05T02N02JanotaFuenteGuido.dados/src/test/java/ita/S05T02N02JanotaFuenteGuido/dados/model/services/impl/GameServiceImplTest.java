package ita.S05T02N02JanotaFuenteGuido.dados.model.services.impl;

import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.GameDto;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N02JanotaFuenteGuido.dados.model.repository.IPlayerRepository;
import ita.S05T02N02JanotaFuenteGuido.dados.utils.mapper.EntityDtoMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.TestComponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class GameServiceImplTest {

    @Mock private IPlayerRepository playerRepository;
    @Mock private EntityDtoMapper entityDtoMapper;

    @InjectMocks private GameServiceImpl gameServiceImpl;

    private Player player;

    @BeforeEach
    void setUp(){
        List<Game> games = new ArrayList<>();
        games.add(new Game(6,1,true));

        player = Player.builder()
                .id("id")
                .userName("userName")
                .games(games)
                .victories(1)
                .build();
    }

    @Test
    void shouldCreateNewGame(){
        //given
        Mockito.when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));
        Mockito.when(entityDtoMapper.toGameDto(Mockito.any(Game.class)))
                .thenAnswer(invocation -> {
                    Game invGame = invocation.getArgument(0);
                    return GameDto.builder()
                            .diceA(invGame.getDiceA())
                            .diceB(invGame.getDiceB())
                            .win(invGame.isWin())
                            .build();
                });

        //when
       GameDto result = gameServiceImpl.newGame(player.getId());

        //then
        Assertions.assertThat(result).isNotNull();
        Mockito.verify(playerRepository, times(1)).save(Mockito.any(Player.class));
//        System.out.println(result.getDiceA());
//        System.out.println(result.getDiceB());
//        System.out.println(result.isWin());
//        System.out.println(player.getVictories());

    }

    @Test
    void shouldDeleteAllGamesByPlayerId(){
        //given
        Mockito.when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));

        //when
        boolean result = gameServiceImpl.deleteAllGamesByPlayerId(player.getId());

        //then
        Assertions.assertThat(result).isTrue();
        Assertions.assertThat(player.getGames().size()).isEqualTo(0);
        Mockito.verify(playerRepository, times(1)).save(Mockito.any(Player.class));


    }
}