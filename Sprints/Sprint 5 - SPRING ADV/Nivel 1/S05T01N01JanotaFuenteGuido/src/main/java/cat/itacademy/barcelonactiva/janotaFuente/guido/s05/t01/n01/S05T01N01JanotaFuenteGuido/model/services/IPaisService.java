package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.domain.Pais;

public interface IPaisService {
	
	List<Pais> listaPaises();
	
	void addPais(Pais pais);
	
	void deletePais(Long id);

}
