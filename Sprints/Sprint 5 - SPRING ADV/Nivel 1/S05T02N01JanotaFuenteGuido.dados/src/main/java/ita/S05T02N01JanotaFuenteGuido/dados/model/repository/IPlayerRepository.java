package ita.S05T02N01JanotaFuenteGuido.dados.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Integer> {
	
	//Usa una lista para poder encontrar todos los jugadores que tengan el nombre por defecto: "NoNamePlayer"
	List<Player> findByName(String name); 

}
