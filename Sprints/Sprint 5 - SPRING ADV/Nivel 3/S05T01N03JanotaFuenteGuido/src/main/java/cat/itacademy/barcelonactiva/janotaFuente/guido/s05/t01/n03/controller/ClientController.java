package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.controller;


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

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.services.IClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping ("/web-client")


public class ClientController {
	
	@Autowired
	IClienteService clienteService;
	
	@ApiOperation(value = "Visualiza todas las flores",
				  notes = "Devuelve una lista de todas las flores disponibles en la BD o NULL si no hay contenido disponible")
    @ApiResponses(value = {
				            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente"),
				            @ApiResponse(code = 204, message = "NO_CONTENT. No hay contenido para mostrar")})
	@GetMapping("getAll")
	public ResponseEntity<?> listFlores(){
		List<FlorDTO> flores = clienteService.getAllFlores();
		if (flores==null) {
			System.out.println("No hay datos en la BD");
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(flores, HttpStatus.OK);
	}

	@ApiOperation(value = "Agrega una flor a la BD",
					notes = "Devuelve la Flor agregada o NULL si hay errores")
	@ApiResponses(value = {
							@ApiResponse(code = 201, message = "OK. El recurso se agregó correctamente"),
							@ApiResponse(code = 500, message = "SERVER ERROR. Error al agregar la Flor")})	
	@PostMapping("/save")
	public ResponseEntity<?> addFlor(@RequestBody FlorDTO florDto) {
		try {
			clienteService.saveFlor(florDto);
			System.out.println("Flor Guardada con Éxito");
			return new ResponseEntity<>(florDto, HttpStatus.CREATED);
			
		}catch(Exception e) {
			System.out.println("Algo Falló");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 

		}
		
	}
	
	@ApiOperation(value = "Busca una Flor por identificador",
					notes = "Devuelve una Flor o un String con información")
	@ApiResponses(value = {
					       @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente"),
					       @ApiResponse(code = 404, message = "NOT FOUND. No se encontró la Flor")})
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
	
	
	@ApiOperation(value = "Actualiza la informacion de una Flor por identificador",
					notes = "Devuelve la Flor actualizada o un String con información")
	@ApiResponses(value = {
							@ApiResponse(code = 201, message = "OK. El recurso se modifica/actualiza correctamente"),
							@ApiResponse(code = 404, message = "NOT FOUND. No se encontró la Flor")})
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editFlor(@PathVariable("id") Long id, @RequestBody FlorDTO florDto) {
		FlorDTO _florDto = clienteService.updateFlor(id, florDto);
		
		if(_florDto==null) {
			System.out.println("No hay datos con id: "+id);
			return new ResponseEntity<>("No se encontraron flores con id: " + id, HttpStatus.NOT_FOUND);
			
		} else {
			System.out.println("Se actualizo Flor con id: " +id);
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
		if(clienteService.getOneById(id)==null) {
			System.out.println("No hay datos con id: "+id);
			return new ResponseEntity<>("No se encontraron flores con id: " + id, HttpStatus.NOT_FOUND);
									
		} else {
			clienteService.deleteFlor(id);
			System.out.println("Flor con ID: "+id+" borrada");
			return new ResponseEntity<>("Borrado Exitoso", HttpStatus.OK);			
		}
	
	}
	



}
