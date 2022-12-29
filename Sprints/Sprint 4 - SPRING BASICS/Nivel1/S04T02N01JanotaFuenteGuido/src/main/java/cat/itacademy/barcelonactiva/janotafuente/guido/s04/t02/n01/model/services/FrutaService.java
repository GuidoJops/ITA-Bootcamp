package cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.repository.IFrutaRepository;

@Service
public class FrutaService {
	
	@Autowired
	IFrutaRepository frutaRepo;
	

//	public void addFruta(Fruta fruta) {
//		frutaRepo.save(new Fruta(fruta.getNombre(), fruta.getCantidadQuilos()));
//	}
	
	
	//CHEQUEAR SI YA EXISTE??
	public boolean addFruta(Fruta fruta) {
		boolean frutaOk = false;
		if (checkBody(fruta)) {
			frutaRepo.save(new Fruta(fruta.getNombre(), fruta.getCantidadQuilos()));
			frutaOk = true;
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
		if(frutaData.isPresent()) {
			return frutaData.get();
		}
		return null;
		
	}

	public Fruta updateFruta(int id, Fruta fruta) {
		if(checkBody(fruta)) {
			Fruta _fruta = getOneFruta(id);
			if(_fruta !=null) {
				_fruta.setNombre(fruta.getNombre());
				_fruta.setCantidadQuilos(fruta.getCantidadQuilos());
				
				return frutaRepo.save(_fruta);
			}
		}
		return null;
	}
	
	
	
	//Métodos Extra
	 public boolean checkBody(Fruta fruta) {
			boolean frutaOk = false;
		 if (fruta.getNombre() != null && fruta.getCantidadQuilos() > 0) {
				frutaOk = true;
			}
			return frutaOk;
	 }

}
