package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.model.services.IFlorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping ("/api/flor")
public class FlorController {
	
	@Autowired
	private IFlorService florServ;
	
	// Anotaciones para la documentación Swagger (@ApiOperation - @ApiResponses)
	
	
	@ApiOperation(value = "Visualiza todas las flores",
				  notes = "Devuelve un listado de todas las flores disponibles en la BD")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente"),
            @ApiResponse(code = 204, message = "No hay contenido para mostrar")})
	@GetMapping("getAll")
	public ResponseEntity<?> listFlores(){
		List<FlorDTO> flores = florServ.getAllFlores();
		if (flores.isEmpty()) {
			return new ResponseEntity<>("No hay flores en el sistema", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(flores, HttpStatus.OK);
	}

	@ApiOperation(value = "Agrega una flor a la BD",
				  notes = "Devuelve la Flor agregada")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "OK. El recurso se agregó correctamente"),
			@ApiResponse(code = 500, message = "SERVER ERROR. Error al agregar la Flor")})	
	@PostMapping("/add")
	public ResponseEntity<?> addFlor(@RequestBody FlorDTO florDto) {
		if(!florServ.saveFlor(florDto)) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return new ResponseEntity<>(florDto, HttpStatus.CREATED);	
		
	}
	
	@ApiOperation(value = "Busca una Flor por identificador",
				 notes = "Devuelve una Flor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente"),
            @ApiResponse(code = 404, message = "NOT FOUND. No se encontró la Flor")})
	@GetMapping("/search/{id}")
	public ResponseEntity<?> searchById(@PathVariable("id") Long id) {
        FlorDTO florDto = new FlorDTO();
        florDto = florServ.getOneById(id);
      
        if(florDto==null) {
        	
			System.out.println("No hay datos con id: "+id);
			return new ResponseEntity<>("No se encontraron flores con id: " + id, HttpStatus.NOT_FOUND);
			
		} else {
			System.out.println("Flor Encontrada!");
			return new ResponseEntity<>(florDto, HttpStatus.OK);	

		}
				
	}
	
	@ApiOperation(value = "Actualiza la informacion de una Flor por identificador",
			  	  notes = "Devuelve la Flor actualizada")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "OK. El recurso se modifica/actualiza correctamente"),
			@ApiResponse(code = 404, message = "NOT FOUND. No se encontró la Flor")})
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editFlor(@PathVariable("id") Long id, @RequestBody FlorDTO florDto) {
		FlorDTO _florDto = florServ.updateFlor(id, florDto);
		
		if(_florDto==null) {
			System.out.println("No hay datos con id: "+id);
			return new ResponseEntity<>("No se encontraron flores con id: " + id, HttpStatus.NOT_FOUND);
			
		} else {
			System.out.println("Flor Encontrada!");
			return new ResponseEntity<>(florDto, HttpStatus.CREATED);	
		
		}
	
	}
	
	@ApiOperation(value = "Borra la informacion de una Flor por identificador",
				  notes = "Devuelve un String con información de la operación")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK. El recurso se borra correctamente"),
			@ApiResponse(code = 404, message = "NOT FOUND. No se encontró la Flor")})
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteFlor(@PathVariable("id") Long id) {
		if(florServ.getOneById(id)==null) {
			System.out.println("No hay datos con id: "+id);
			return new ResponseEntity<>("No se encontraron flores con id: " + id, HttpStatus.NOT_FOUND);
									
		} else {
			System.out.println("Flor con ID: "+id+" borrada");
			return new ResponseEntity<>("Borrado Exitoso", HttpStatus.OK);			
		}
	
	}
	

}
