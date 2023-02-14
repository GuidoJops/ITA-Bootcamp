package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.converter;

import java.util.List;
import org.springframework.stereotype.Component;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.model.dto.FlorDTO;

@Component
public class FlorConverter {
	
	private Flor flor;
	private FlorDTO florDto;
	
	
	public Flor getFlor() {
		return flor;
	}

	public void setFlor(Flor flor) {
		this.flor = flor;
	}

	public FlorDTO getFlorDto() {
		return florDto;
	}

	public void setFlorDto(FlorDTO florDto) {
		this.florDto = florDto;
	}

	public FlorDTO entityToDto(Flor flor) {
		if(flor !=null) {
			String nombrePais = flor.getPaisFlor();
			FlorDTO florDto = new FlorDTO();
			
			florDto.setId(flor.getId());
			florDto.setNombreFlor(flor.getNombreFlor());
			florDto.setPaisFlor(flor.getPaisFlor());
			florDto.setTipoFlor(florDto.defindeTipoFlor(nombrePais));
			
			System.out.println("Devolviendo DTO...");
			
			return florDto;
		}
		
		
		return null;
	}
	
	public List<FlorDTO> entityToDto(List<Flor> listEntity){
		System.out.println("Devolviendo Lista DTO...");

		return listEntity.stream().map(x-> entityToDto(x)).toList();
	}
	
	public Flor dtoToEntity(FlorDTO florDto) {
		Flor flor = new Flor();
		
		flor.setId(florDto.getId());
		flor.setNombreFlor(florDto.getNombreFlor());
		flor.setPaisFlor(florDto.getPaisFlor());
		
		System.out.println("Devolviendo Entidad...");

		return flor;
		
	}
	
}
