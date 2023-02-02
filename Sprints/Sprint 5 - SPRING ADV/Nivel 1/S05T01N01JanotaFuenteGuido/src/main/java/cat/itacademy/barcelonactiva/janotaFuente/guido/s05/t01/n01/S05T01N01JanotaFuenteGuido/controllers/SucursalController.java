package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.domain.Pais;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services.IPaisService;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services.ISucursalService;

@Controller
@RequestMapping ("/sucursal")
public class SucursalController {
	
	@Autowired
	private ISucursalService sucursalServ;
	
	@Autowired
	private IPaisService paisServ;
	

	//Muestra lista de Sucursales
	@GetMapping("")
	public String listSucursales(Model model){
		model.addAttribute("titulo", "Sucursales Disponibles");
		model.addAttribute("sucursales", sucursalServ.getAllSucursales());

		return "/views/sucursales/list-sucursales";
	}
	
	@GetMapping("/add")
	public String showNewSucursalForm(Model model) {
		SucursalDto sucursaldto = new SucursalDto();
		List<Pais> paises = paisServ.listaPaises();
	
		model.addAttribute("titulo", "Agregar Sucursal");
		model.addAttribute("boton", "Guardar Sucursal");
		model.addAttribute("sucursal",sucursaldto);
		model.addAttribute("paises",paises);

		return "/views/sucursales/form-save-sucursal";
	}
	
	@PostMapping("/save")
	public String saveSucursal(@ModelAttribute SucursalDto sucursalDto) {
		sucursalServ.saveSucursal(sucursalDto);
		System.out.println("Guardado");
				
		return "redirect:/sucursal";
	}
	
	@GetMapping("/{id}")
	public String showSucursal(@PathVariable("id") long id, Model model) {
		model.addAttribute("titulo", "Sucursal Encontrada");
		model.addAttribute("sucursales", sucursalServ.getOneSucursal(id)); //VER QUE HACER SI NO LA ENCUENTRA - PAGINA DE ERROR?

		return "/views/sucursales/list-sucursales";
	}

	@GetMapping("/update/{id}")
	public String updateSucursal(@PathVariable("id") Long id, Model model) {
		SucursalDto sucursaldto = sucursalServ.getOneSucursal(id);
		List<Pais> paises = paisServ.listaPaises();
	
		model.addAttribute("titulo", "Editar Sucursal");
		model.addAttribute("boton", "Actualizar Sucursal");
		model.addAttribute("sucursal",sucursaldto);
		model.addAttribute("paises",paises);
		
		return "/views/sucursales/form-save-sucursal";
	
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSucursal(@PathVariable("id") Long id) {
		sucursalServ.deleteSucursal(id);
		
		return "redirect:/sucursal";
	
	}
	

}
