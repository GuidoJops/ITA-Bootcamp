package ita.S05T02N01JanotaFuenteGuido.dados.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;

@Repository
public interface IPlayerRepository extends  MongoRepository <Player, String>{
	
	//Usa una lista para poder encontrar todos los jugadores que tengan el nombre por defecto: "NoNamePlayer"
	List<Player> findByName(String name);
	Optional<Player> findByUserName(String userName);
	Boolean existsByUserName(String userName);
}
