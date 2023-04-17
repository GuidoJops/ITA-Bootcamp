package ita.S05T02N02JanotaFuenteGuido.dados.model.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ita.S05T02N02JanotaFuenteGuido.dados.model.domain.Player;

@Repository
public interface IPlayerRepository extends MongoRepository <Player, String>{
	
	Optional<Player> findByUserName(String userName);
	Boolean existsByUserName(String userName);
}


