package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.services.IClienteService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping ("/web-client")


public class ClientController {
	
	@Autowired
	IClienteService clienteService;
	
	
	 @GetMapping("/getAll")
	    public Mono<?> getflors() {
	        try {
	            return clienteService.getAllFlores();
	        }catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
	    }
	
//	@GetMapping("getAll")
//	public ResponseEntity<?> listFlores(){
//		List<FlorDTO> flores = clienteService.getAllFlores();
//		if (flores.isEmpty()) {
//			return new ResponseEntity<>("No hay flores en el sistema", HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(flores, HttpStatus.OK);
//	}
	
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> searchById(@PathVariable("id") Long id) {

        FlorDTO florDto = clienteService.getOneById(id);
      
        if(florDto==null) {
        	
			System.out.println("No hay datos con id: "+id);
			return new ResponseEntity<>("No hay registros con id: " + id, HttpStatus.NOT_FOUND);
			
		} else {
			System.out.println("Se encontró Flor");
			return new ResponseEntity<>(florDto, HttpStatus.OK);	

		}
				
	}

	@PostMapping("/add")
	public ResponseEntity<?> addFlor(@RequestBody FlorDTO florDto) {
		if(!clienteService.saveFlor(florDto)) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return new ResponseEntity<>(florDto, HttpStatus.CREATED);	
		
	}



}
