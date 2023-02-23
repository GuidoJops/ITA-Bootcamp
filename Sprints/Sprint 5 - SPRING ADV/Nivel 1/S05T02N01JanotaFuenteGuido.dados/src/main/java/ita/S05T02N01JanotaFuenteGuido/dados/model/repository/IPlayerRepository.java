package ita.S05T02N01JanotaFuenteGuido.dados.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Integer> {

	Optional<Player> findByName(String name);

}
