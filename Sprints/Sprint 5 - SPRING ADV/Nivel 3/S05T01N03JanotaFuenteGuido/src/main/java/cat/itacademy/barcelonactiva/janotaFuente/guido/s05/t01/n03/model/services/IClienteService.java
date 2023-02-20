package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.ClientResponse;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.dto.FlorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClienteService {
	
	
	List<FlorDTO> getAllFlores();
	
	FlorDTO getOneById(Long id);
	
	void saveFlor (FlorDTO florDto);
	
	void deleteFlor (Long id);

	FlorDTO updateFlor(Long id, FlorDTO florDto);


	
	
	

}
