package cat.itacademy.barcelonactiva.janotaFuente.guido.s04.t02.n03.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s04.t02.n03.domain.Fruta;



public interface IFrutaRepository extends MongoRepository <Fruta, String>{
	
}
