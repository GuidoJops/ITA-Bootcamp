package ita.S05T02N01JanotaFuenteGuido.dados.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Game;

@Repository
public interface IGameRepository extends JpaRepository<Game, Integer> {

}
