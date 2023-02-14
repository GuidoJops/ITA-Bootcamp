package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.model.dto.FlorDTO;

public interface IFlorService {
	
	
	List<FlorDTO> getAllFlores();
	
	FlorDTO getOneById(Long id);
	
	FlorDTO getOneByName(String nombre);
	
	boolean saveFlor (FlorDTO florDto);
	
	void deleteFlor (Long id);

	FlorDTO updateFlor(Long id, FlorDTO florDto);


	
	
	

}
