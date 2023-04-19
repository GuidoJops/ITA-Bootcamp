package ita.S05T02N02JanotaFuenteGuido.dados.model.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerTest {

     @Test
    void shouldResetPlayer() {
        //given
        Player player = Player.builder()
                .winSuccess(6)
                .victories(3)
                .games(Arrays.asList(new Game()))
                .build();
        //when
        player.resetPlayer();

        //then
        Assertions.assertThat(player.getWinSuccess()).isEqualTo(0);
        Assertions.assertThat(player.getVictories()).isEqualTo(0);
        Assertions.assertThat(player.getGames().size()).isEqualTo(0);

    }

    @Test
    void shouldCalculateWinSuccess(){
        //given
        List<Game> games = Arrays.asList(
                new Game(1,3,false),
                new Game(6,1,true)
                //Total 3 Games. Uno lo tiene en cuenta el método por default
        );

        Player player = Player.builder()
                .victories(1)
                .games(games)
                .build();

        //when
        double result = player.winSuccesCalculator();

        //then
        Assertions.assertThat(result).isEqualTo(33.3);
    }

}