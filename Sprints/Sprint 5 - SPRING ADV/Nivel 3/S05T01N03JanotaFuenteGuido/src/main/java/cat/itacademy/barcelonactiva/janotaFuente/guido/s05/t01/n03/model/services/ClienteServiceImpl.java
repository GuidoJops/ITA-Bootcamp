package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.repository.ClientRepository;
import reactor.core.publisher.Mono;


@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private ClientRepository webRepository;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FlorDTO> getAllFlores() {
		return webRepository.getWebClient().get()
				.uri("/getAll")
				.retrieve()
				.bodyToMono(List.class)
				.block();
	}
		
	@Override
	public FlorDTO getOneById(Long id) {
		return webRepository.getWebClient().get()
				.uri("/search/{id}", id)
				.retrieve()
				.bodyToMono(FlorDTO.class)
				.onErrorComplete()
				.block();
			
	}
	
	@Override
	public void saveFlor(FlorDTO florDto) {
		webRepository.getWebClient().post()
		.uri("/add")
		.body(Mono.just(florDto), FlorDTO.class)
		.retrieve()
		.bodyToMono(FlorDTO.class)
		.block();

	}

	@Override
	public void deleteFlor(Long id) {
		webRepository.getWebClient().delete()
		.uri("/delete/{id}", id)
		.retrieve()
		.bodyToMono(Void.class)
		.block();
	}

	@Override
	public FlorDTO updateFlor(Long id, FlorDTO florDto) {
		FlorDTO _florDto = getOneById(id);
		if (_florDto!=null) {
			return webRepository.getWebClient().put()
					.uri("/edit/{id}", id)
					.body(Mono.just(florDto), FlorDTO.class)
					.retrieve()
					.bodyToMono(FlorDTO.class)
					.block();
		} else {
			return null;			
		}
		
	}
	
	
	
}
