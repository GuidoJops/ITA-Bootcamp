package ita.S05T02N01JanotaFuenteGuido.dados.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;

public interface IPlayerRepository extends JpaRepository<Player, Integer> {

}
