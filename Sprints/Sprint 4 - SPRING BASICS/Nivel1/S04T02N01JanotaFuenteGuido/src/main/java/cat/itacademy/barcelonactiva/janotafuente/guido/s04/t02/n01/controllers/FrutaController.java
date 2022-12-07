package cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.repository.IFrutaRepository;

@RestController
@RequestMapping("/fruta")
public class FrutaController {

	@Autowired
	IFrutaRepository frutaRepo;
	
	
	@PostMapping("/add") //QUIZAS SIN EL ADD MEJOR??
	public ResponseEntity<Fruta> addFruta(@RequestBody Fruta fruta) {
		Fruta _fruta = frutaRepo.save(new Fruta(fruta.getNombre(), fruta.getCantidadQuilos()));
		
		return new ResponseEntity<>(_fruta, HttpStatus.CREATED);
	}
}
