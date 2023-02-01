package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.domain.Pais;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services.IPaisService;


//-------La idea es cargar Paises mediante PostMan a la Base de Datos-------
//BUSCAR MANERA DE CARGAR TODOS LOS PAISES AUTOMATICAMENTE A LA BD


@Controller
@RequestMapping ("/pais")
public class PaisController {

	@Autowired
	private IPaisService serv;
	
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getPaises(){
		List<Pais> pais = serv.listaPaises();
		if (pais.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(pais,HttpStatus.OK);
	}
	
	
	@PostMapping("/add") 
	public ResponseEntity<?> addPais(@RequestBody Pais pais) {
		serv.addPais(pais);
		return new ResponseEntity<>(pais, HttpStatus.CREATED);
	
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePais(@PathVariable("id") Long id) {
		serv.deletePais(id);
		return new ResponseEntity<>("Borrado Exitoso", HttpStatus.OK);
	
	}
	
}
