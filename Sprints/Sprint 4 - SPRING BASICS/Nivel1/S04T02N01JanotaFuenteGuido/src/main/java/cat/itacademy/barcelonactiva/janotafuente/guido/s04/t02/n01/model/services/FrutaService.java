package cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.repository.IFrutaRepository;

@Service
public class FrutaService {
	
	private static Logger logger = LoggerFactory.getLogger(FrutaService.class);
	
	@Autowired
	IFrutaRepository frutaRepo;
	

	//REST Methods	
	public boolean addFruta(Fruta fruta) {
		boolean frutaOk = false;
		if (checkBody(fruta)) {
			frutaRepo.save(new Fruta(fruta.getNombre(), fruta.getCantidadQuilos()));
			frutaOk = true;
			logger.info("Fruta Agregada");
		}
		return frutaOk;
		
	}
		
	public List<Fruta> getAllFrutas() {
		List<Fruta> frutas = new ArrayList<Fruta>();
		frutaRepo.findAll().forEach(frutas::add);
		return frutas;
		
	}

	public Fruta getOneFruta(int id) {
		Optional<Fruta> frutaData = frutaRepo.findById(id);
		if(frutaData.isEmpty()) {
			logger.info("No existe Fruta con id "+ id);
			return null;
		}
		logger.info("Fruta Encontrada");
		return frutaData.get();
		
	}

	public Fruta updateFruta(int id, Fruta fruta) {
		if(checkBody(fruta)) {
			Optional<Fruta> frutaData = frutaRepo.findById(id);
			
			if(frutaData.isEmpty()) {
				logger.info("No se encuentra fruta con id " + id);
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
	
	
	public boolean deleteFruta(int id) {
		boolean ok = false;
		try {
			frutaRepo.deleteById(id);
			logger.info("Fruta Borrada");
			ok = true;
		} catch(Exception e) {
			logger.info(e.getMessage());
			
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
