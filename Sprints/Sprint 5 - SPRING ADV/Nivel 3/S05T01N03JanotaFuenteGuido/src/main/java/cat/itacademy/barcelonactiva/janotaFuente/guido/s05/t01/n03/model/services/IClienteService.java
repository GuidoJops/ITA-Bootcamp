package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.dto.FlorDTO;


public interface IClienteService {
	
	
	List<FlorDTO> getAllFlores();
	
	FlorDTO getOneById(Long id);
	
	void saveFlor (FlorDTO florDto);
	
	void deleteFlor (Long id);

	FlorDTO updateFlor(Long id, FlorDTO florDto);


	
	
	

}
