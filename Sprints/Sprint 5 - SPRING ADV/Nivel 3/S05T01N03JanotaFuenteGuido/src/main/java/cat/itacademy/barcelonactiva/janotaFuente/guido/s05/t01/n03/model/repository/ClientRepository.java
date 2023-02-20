package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository 
public class ClientRepository {


	private final WebClient webClient;
	

	public ClientRepository() {
		webClient = WebClient.create("http://localhost:9001/api/flor");
	}

	public WebClient getWebClient() {
		return webClient;
	}

	
			
}
	
