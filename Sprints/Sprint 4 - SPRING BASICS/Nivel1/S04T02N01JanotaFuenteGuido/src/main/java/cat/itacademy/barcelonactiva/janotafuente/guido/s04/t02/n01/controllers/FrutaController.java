package cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.services.FrutaService;

@RestController
@RequestMapping("/fruta")
public class FrutaController {

	
	@Autowired
	FrutaService frutaServ;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Fruta>> getFrutas(){
		List<Fruta> frutas = frutaServ.getAllFrutas();
		if (frutas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(frutas,HttpStatus.OK);
	}
	
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruta> getFruta(@PathVariable("id") int id){
		Fruta fruta = frutaServ.getOneFruta(id);
		if (fruta!= null) {
			return new ResponseEntity<>(fruta,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
	}
	
	
	@PostMapping("/add") 
	public ResponseEntity<Fruta> addFruta(@RequestBody Fruta fruta) {
		if (frutaServ.addFruta(fruta)) {
			return new ResponseEntity<>(fruta, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
		

	//DEVUELVE NOT FOUND CUANDO INGRESO BODY ERRONEO
	@PutMapping("/update/{id}")
	public ResponseEntity<Fruta> updateFruta(@PathVariable("id") int id, @RequestBody Fruta fruta){
		if (frutaServ.updateFruta(id, fruta)!= null) {
			return new ResponseEntity<>(fruta,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
	}
}
