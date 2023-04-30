package ita.S05T02N02JanotaFuenteGuido.dados.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Game;
import ita.S05T02N02JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N02JanotaFuenteGuido.dados.model.services.IPlayerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.hamcrest.CoreMatchers.is;

@WebMvcTest(controllers = PlayerController.class)
@AutoConfigureMockMvc (addFilters = false)
@ExtendWith(MockitoExtension.class)
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPlayerService playerService;

//    @Autowired
//    private ObjectMapper objectMapper;



    @Test
    void shouldGetPlayers() throws Exception {
        //given
        List<PlayerDto> playersDto = Arrays.asList(
                PlayerDto.builder().name("1").build(),
                PlayerDto.builder().name("2").build()
        );
        Mockito.when(playerService.getAllPlayers()).thenReturn(playersDto);

        //when
        ResultActions response = mockMvc.perform(get("/players")
                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(playersDto))
        );

        //then
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(playersDto.size())));

    }

    @Test
    void shouldChangePlayerName() throws Exception {
        //given
        PlayerDto playerDto = PlayerDto.builder().name("name").build();
        Mockito.when(playerService.changePlayerName("id", "name")).thenReturn(playerDto);

        //when
        ResultActions response = mockMvc.perform(put("/players/id")
                .contentType(MediaType.APPLICATION_JSON)
                .param("name", "name"));

        //then
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(playerDto.getName())));
    }

    @Test
    void shouldGetPlayerGames() throws Exception {
        //given
        List<Game> games = Arrays.asList(new Game(), new Game(), new Game());
        Mockito.when(playerService.getGamesByPlayerId("id")).thenReturn(games);

        //when
        ResultActions response = mockMvc.perform(get("/players/id/games")
                .contentType(MediaType.APPLICATION_JSON));

        //then
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(games.size())));

    }

    @Test
    void shouldGetPlayersRanking() throws Exception {
        //given
        Map<String, Double> playersRanking = new HashMap<>();
        playersRanking.put("juan", 23.3);
        playersRanking.put("maria", 50.0);

        Mockito.when(playerService.getAllPlayersRanking()).thenReturn(playersRanking);

        //when
        ResultActions response = mockMvc.perform(get("/players/ranking")
                .contentType(MediaType.APPLICATION_JSON));

        //then
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$", aMapWithSize(playersRanking.size())));
    }

    @Test
    void shouldGetWinnerPlayer() throws Exception {
        //given
        PlayerDto playerDto = PlayerDto.builder().name("winner").build();
        Mockito.when(playerService.getPlayerWinner()).thenReturn(playerDto);

        //when
        ResultActions response = mockMvc.perform(get("/players/ranking/winner")
                .contentType(MediaType.APPLICATION_JSON));

        //then
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(playerDto.getName())));
    }

    @Test
    void shouldGetLoserPlayer() throws Exception {
        //given
        PlayerDto playerDto = PlayerDto.builder().name("loser").build();
        Mockito.when(playerService.getPlayerLoser()).thenReturn(playerDto);

        //when
        ResultActions response = mockMvc.perform(get("/players/ranking/loser")
                .contentType(MediaType.APPLICATION_JSON));

        //then
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(playerDto.getName())));
    }

}