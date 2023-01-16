package cat.itacademy.barcelonactiva.janotaFuente.guido.s04.t02.n03.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s04.t02.n03.domain.Fruta;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s04.t02.n03.repository.IFrutaRepository;



@Service
public class FrutaServiceImpl implements IFrutaService {
	
	private static Logger logger = LoggerFactory.getLogger(FrutaServiceImpl.class);
	
	@Autowired
	IFrutaRepository frutaRepo;
	

	@Override
	public List<Fruta> getAll() {
		List<Fruta> frutas = new ArrayList<Fruta>();
		frutaRepo.findAll().forEach(frutas::add);
		return frutas;
	}


	@Override
	public Fruta getOne(String id) {
		Optional<Fruta> frutaData = frutaRepo.findById(id);
		if(frutaData.isEmpty()) {
			logger.warn("No existe Fruta con id "+ id);
			return null;
		}
		logger.info("Fruta Encontrada");
		return frutaData.get();	
	}
	

	@Override
	public boolean addFruta(Fruta fruta) {
		boolean frutaOk = false;
		if (checkBody(fruta)) {
			frutaRepo.save(new Fruta(fruta.getNombre(), fruta.getCantidadQuilos()));
			frutaOk = true;
			logger.info("Fruta Agregada");
		}
		return frutaOk;
	}


		
	@Override
	public Fruta updateFruta(String id, Fruta fruta) {
		if(checkBody(fruta)) {
			Optional<Fruta> frutaData = frutaRepo.findById(id);
			
			if(frutaData.isEmpty()) {
				logger.warn("No se encuentra fruta con id " + id);
				return null;
				
			} else {
				frutaData.get().setNombre(fruta.getNombre());
				frutaData.get().setCantidadQuilos(fruta.getCantidadQuilos());
				logger.info("Fruta Actualizada a --> "+frutaData.get());
				return frutaRepo.save(frutaData.get());
			}
		}
		logger.info("Body Incorrecto");
		return fruta;	
	}

	
	@Override
	public boolean deleteFruta(String id) {
		boolean ok = false;
		Optional<Fruta> frutaData = frutaRepo.findById(id);
		
		if(frutaData.isPresent()) {
			frutaRepo.deleteById(id);
			logger.info("Fruta Borrada");
			ok = true;
		} else {
			logger.warn("ID de Fruta inválido");
		}
		return ok;	
	}
	


	
	//Extra Methods
	 public boolean checkBody(Fruta fruta) {
			boolean frutaOk = false;
		 if (fruta.getNombre() != null && fruta.getCantidadQuilos() > 0) {
				frutaOk = true;
			}
			return frutaOk;
	 }



	

	 
	
}
