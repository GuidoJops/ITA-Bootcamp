package cat.itacademy.barcelonactiva.janotaFuente.Guido.s04.t02.n02.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.janotaFuente.Guido.s04.t02.n02.domain.Fruta;


public interface IFrutaRepository extends JpaRepository <Fruta, Integer>{
	
}
