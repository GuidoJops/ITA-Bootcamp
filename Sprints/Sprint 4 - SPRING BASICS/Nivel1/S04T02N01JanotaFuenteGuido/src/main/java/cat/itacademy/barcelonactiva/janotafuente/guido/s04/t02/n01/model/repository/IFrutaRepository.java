package cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.domain.Fruta;

public interface IFrutaRepository extends JpaRepository <Fruta, Integer>{
	
}
