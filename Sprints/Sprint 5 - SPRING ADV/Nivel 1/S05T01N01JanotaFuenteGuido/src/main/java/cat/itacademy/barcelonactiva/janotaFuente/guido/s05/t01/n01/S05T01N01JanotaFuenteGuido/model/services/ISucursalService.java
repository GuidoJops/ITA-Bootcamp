package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.dto.SucursalDto;

public interface ISucursalService {
	
	
	List<SucursalDto> getAllSucursales();
	
	SucursalDto getOneById(Long id);
	
	SucursalDto getOneByName(String nombre);
	
	void saveSucursal (SucursalDto sucursalDto);
	
	void deleteSucursal (Long id);
	
	
	

}
