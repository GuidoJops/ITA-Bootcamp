package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.converter.SucursalConverter;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.domain.Sucursal;
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
	public Sucursal getOneSucursal(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSucursal(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSucursal(Long id) {
		// TODO Auto-generated method stub
		
	}

}
