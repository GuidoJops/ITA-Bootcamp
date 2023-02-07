package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.domain.Pais;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services.IPaisService;

@SpringBootApplication
public class S05T01N01JanotaFuenteGuidoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N01JanotaFuenteGuidoApplication.class, args);
	}
	
	
	@Autowired
	private IPaisService paisService;

	@Override
	public void run(String... args) throws Exception {
		
		// Carga Paises a BD desde un Json File
		System.out.println("----INICIALIZACION DE PAISES---\n");

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Pais>> typeReference = new TypeReference<List<Pais>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/paises.json");
		
		//Verifica si los paises ya se cargaron previamente
		if (paisService.listaPaises().size()==0) {
			System.out.println("No se encontraron datos de Paises en el sistema.");
			System.out.println("Recuperando datos de Paises.... ");
			List<Pais> paises = mapper.readValue(inputStream, typeReference);
			paisService.addMultiplePais(paises);
			
		} else {
			System.out.println("Paises inicializados previamente.");

		}
		System.out.println("\n----INICIALIZACION DE PAISES TERMINADA----");

	};
	

}
