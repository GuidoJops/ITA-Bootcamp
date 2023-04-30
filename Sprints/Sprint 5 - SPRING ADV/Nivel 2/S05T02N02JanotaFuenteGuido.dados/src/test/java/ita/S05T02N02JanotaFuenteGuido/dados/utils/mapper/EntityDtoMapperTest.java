package ita.S05T02N02JanotaFuenteGuido.dados.utils.mapper;

import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.ERole;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Role;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.GameDto;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.PlayerDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EntityDtoMapperTest {

    @Autowired
    private EntityDtoMapper entityDtoMapper;


    @Test
    void shouldReturnPlayerDto() {
        //given
        Player player = Player.builder()
                .id("id")
                .name("testName")
                .userName("test@gmail.com")
                .password("testpswd")
                .registDate(new Date())
                .winSuccess(33)
                .victories(1)
                .games(Arrays.asList(new Game()))
                .roles(Arrays.asList(new Role(2l, ERole.ROLE_USER)))
                .build();

//        //when
        PlayerDto result = entityDtoMapper.toPlayerDto(player);

        //then
        Assertions.assertThat(result.getName()).isEqualTo(player.getName());
        Assertions.assertThat(result.getUserName()).isEqualTo(player.getUserName());
        Assertions.assertThat(result.getWinSuccess()).isEqualTo(player.getWinSuccess());
    }

    @Test
    void shouldReturnGameDto() {
        //given
        Game game = new Game();

        //when
        GameDto result = entityDtoMapper.toGameDto(game);

        //then
        Assertions.assertThat(result.getDiceA()).isEqualTo(game.getDiceA());
        Assertions.assertThat(result.getDiceB()).isEqualTo(game.getDiceB());
        Assertions.assertThat(result.isWin()).isEqualTo(game.isWin());

    }
}