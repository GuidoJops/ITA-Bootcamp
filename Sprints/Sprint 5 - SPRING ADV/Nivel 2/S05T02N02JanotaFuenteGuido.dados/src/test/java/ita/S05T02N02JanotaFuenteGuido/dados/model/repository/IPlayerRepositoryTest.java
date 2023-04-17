package ita.S05T02N02JanotaFuenteGuido.dados.model.repository;

import static org.assertj.core.api.Assertions.assertThat;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


//@SpringBootTest
@DataMongoTest
class IPlayerRepositoryTest {

    @Autowired
    private IPlayerRepository playerRepository;

    @Test
    void findByUserNameTest() {
        //given
        Player player = new Player(
                "TestName",
                "test@username.com",
                "testpswd"
        );
        playerRepository.save(player);

        //when
        Player expected = playerRepository.findByUserName("test@username.com").get();

        //then
        assertThat(expected).isNotNull();
    }


    @Test
    void existsByUserName() {
    }
}
