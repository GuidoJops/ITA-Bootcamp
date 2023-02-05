package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.dto.SucursalDto;

public interface ISucursalService {
	
	
	List<SucursalDto> getAllSucursales();
	
	void saveSucursal (SucursalDto sucursalDto);
	
	SucursalDto getOneSucursal(Long id);
	
	void deleteSucursal (Long id);
	

}
