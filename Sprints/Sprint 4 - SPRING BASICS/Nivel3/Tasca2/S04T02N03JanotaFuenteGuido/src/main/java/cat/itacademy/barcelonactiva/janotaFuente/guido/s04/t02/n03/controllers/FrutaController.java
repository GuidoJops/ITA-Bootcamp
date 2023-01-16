package cat.itacademy.barcelonactiva.janotaFuente.guido.s04.t02.n03.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s04.t02.n03.domain.Fruta;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s04.t02.n03.services.IFrutaService;




@RestController
@RequestMapping("/fruta")
public class FrutaController {

	
	@Autowired
	IFrutaService frutaServ;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getFrutas(){
		List<Fruta> frutas = frutaServ.getAll();
		if (frutas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(frutas,HttpStatus.OK);
	}
	
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getFruta(@PathVariable("id") String id){
		Fruta fruta = frutaServ.getOne(id);
		if (fruta!= null) {
			return new ResponseEntity<>(fruta,HttpStatus.OK);
		}
		return new ResponseEntity<>("No se encontró fruta con ese ID",HttpStatus.NOT_FOUND);
				
	}
	
	
	@GetMapping("/getByName/{nombre}")
	public ResponseEntity<?> getFrutaByName(@PathVariable("nombre") String nombre){
		Fruta fruta = frutaServ.getByName(nombre);
		if (fruta!= null) {
			return new ResponseEntity<>(fruta,HttpStatus.OK);
		}
		return new ResponseEntity<>("No se encontró fruta con ese Nombre",HttpStatus.NOT_FOUND);
				
	}
	
	
	@PostMapping("/add") 
	public ResponseEntity<?> addFruta(@RequestBody Fruta fruta) {
		if (frutaServ.addFruta(fruta)) {
			return new ResponseEntity<>(fruta, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateFruta(@PathVariable("id") String id, @RequestBody Fruta fruta) {
		Fruta _fruta = frutaServ.updateFruta(id, fruta);
		
		if (_fruta == fruta) {
			return new ResponseEntity<>("Error en el Body",HttpStatus.BAD_REQUEST);
		
		} else if (_fruta != null) {
			return new ResponseEntity<>(fruta,HttpStatus.CREATED);  
			
		} else {
			return new ResponseEntity<>("No se encontró fruta con ese ID",HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteFruta(@PathVariable("id") String id) {
		if (frutaServ.deleteFruta(id)){
			return new ResponseEntity<>("Borrado Exitoso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
