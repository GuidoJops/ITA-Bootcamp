package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.converter;

import java.util.List;
import org.springframework.stereotype.Component;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.dto.SucursalDto;

@Component
public class SucursalConverter {
	
	private Sucursal sucursal;
	private SucursalDto sucursalDto;
	
	
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public SucursalDto getSucursalDto() {
		return sucursalDto;
	}
	public void setSucursalDto(SucursalDto sucursalDto) {
		this.sucursalDto = sucursalDto;
	}

	
	public SucursalDto entityToDto(Sucursal sucursal) {
		String nombrePais = sucursal.getPaisSucursal().getNombre();
		SucursalDto sucursalDto = new SucursalDto();
		
		sucursalDto.setId(sucursal.getId());
		sucursalDto.setNombreSucursal(sucursal.getNombreSucursal());
		sucursalDto.setPaisSucursal(sucursal.getPaisSucursal());
		sucursalDto.setTipoSucursal(sucursalDto.defindeTipoSucursal(nombrePais));
		
		System.out.println("Devolviendo DTO...");
		
		return sucursalDto;
	}
	
	public List<SucursalDto> entityToDto(List<Sucursal> listEntity){
		System.out.println("Devolviendo Lista DTO...");

		return listEntity.stream().map(x-> entityToDto(x)).toList();
	}
	

	public Sucursal dtoToEntity(SucursalDto sucursalDto) {
		Sucursal sucursal = new Sucursal();
		
		sucursal.setId(sucursalDto.getId());
		sucursal.setNombreSucursal(sucursalDto.getNombreSucursal());
		sucursal.setPaisSucursal(sucursalDto.getPaisSucursal());
		System.out.println("Devolviendo Entidad...");

		return sucursal;
		
	}
	
}
