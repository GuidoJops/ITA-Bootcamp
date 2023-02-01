package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.domain.Pais;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.repository.IPaisRepository;

@Service
public class PaisServiceImpl implements IPaisService {

	@Autowired
	private IPaisRepository paisRepo;
	
	@Override
	public List<Pais> listaPaises() {
		return paisRepo.findAll();
	}

	@Override
	public void addPais(Pais pais) {
		System.out.println("Pais Guardado");
		paisRepo.save(pais);
		
	}

	@Override
	public void deletePais(Long id) {
		paisRepo.deleteById(id);
	}

}
