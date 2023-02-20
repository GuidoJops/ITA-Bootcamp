package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.converter.FlorConverter;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.model.repository.IFlorRepository;

@Service
public class FlorServiceImpl implements IFlorService{
	
	@Autowired
	private IFlorRepository florRepo;

	@Autowired
	private FlorConverter converter;
	
	@Override
	public List<FlorDTO> getAllFlores() {
		List<FlorDTO> dto = converter.entityToDto(florRepo.findAll());
		return dto;
	}

	@Override
	public boolean saveFlor(FlorDTO florDto) {
		boolean ok = false;
		try {
			florRepo.save(converter.dtoToEntity(florDto));
			System.out.println("Flor Agregada");
			ok = true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		return ok;	
	}

	@Override
	public FlorDTO getOneById(Long id) {
		return converter.entityToDto(florRepo.findById(id).orElse(null));
	}

	@Override
	public void deleteFlor(Long id) {
		florRepo.deleteById(id);

	}

	@Override
	public FlorDTO getOneByName(String nombre) {
		return converter.entityToDto(florRepo.findBynombreFlor(nombre));
	}

	@Override
	public FlorDTO updateFlor(Long id, FlorDTO florDto) {
		Optional<Flor> florData = florRepo.findById(id);
		if (florData.isEmpty()) {
	
			return null;
			
		} else {

			florData.get().setNombreFlor(florDto.getNombreFlor());
			florData.get().setPaisFlor(florDto.getPaisFlor());
			florRepo.save(florData.get());
			System.out.println("Flor Actualizada!");

			return converter.entityToDto(florData.get());
			
		}
		
	}



}

