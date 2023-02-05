package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.converter.SucursalConverter;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.repository.ISucursalRepository;

@Service
public class SucursalServiceImpl implements ISucursalService{
	
	@Autowired
	private ISucursalRepository SucRepo;

	@Autowired
	private SucursalConverter converter;
	
	@Override
	public List<SucursalDto> getAllSucursales() {
		List<SucursalDto> dto = converter.entityToDto(SucRepo.findAll());
		return dto;
	}

	@Override
	public void saveSucursal(SucursalDto sucursalDto) {
		SucRepo.save(converter.dtoToEntity(sucursalDto));
	}

	@Override
	public SucursalDto getOneSucursal(Long id) {
//		Optional<Sucursal> sucursaldata = SucRepo.findById(id);
//		if(sucursaldata.isEmpty()) {
//			return null;
//		}
//		return converter.entityToDto(sucursaldata.get());
		return converter.entityToDto(SucRepo.findById(id).orElse(null)); //CHEQUEAR - CREO QUE VA ESTA
	}


	@Override
	public void deleteSucursal(Long id) { //AGREGAR POR SI NO LA ENCUENTRA
		SucRepo.deleteById(id);

	}

}
