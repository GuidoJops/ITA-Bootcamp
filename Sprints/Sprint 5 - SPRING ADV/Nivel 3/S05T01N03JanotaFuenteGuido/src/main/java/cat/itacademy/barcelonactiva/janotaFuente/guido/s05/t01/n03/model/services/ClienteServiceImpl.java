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
	

	
	 public Mono<List> getAllFlores() {
	        return webRepository.getWebClient().get()
					.uri("/getAll")
	                .retrieve()
	                .bodyToMono(List.class)
	                .onErrorComplete();
	 }
	
		
//	@Override
//	public List<FlorDTO> getAllFlores() {
//		return webClient.get()
//				.uri("/getAll")
//				.retrieve()
//				.bodyToMono(List.class)
//				.block();
//	}
//	
	
	
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
	public boolean saveFlor(FlorDTO florDto) {
		boolean ok = false;

		try {
			webRepository.getWebClient().post()
			.uri("/add")
			.body(Mono.just(florDto), FlorDTO.class)
			.retrieve()
			.bodyToMono(FlorDTO.class);
			ok = true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return ok;

	}

	@Override
	public void deleteFlor(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FlorDTO updateFlor(Long id, FlorDTO florDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
