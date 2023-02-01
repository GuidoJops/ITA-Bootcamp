package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.domain.Pais;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services.IPaisService;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services.ISucursalService;

@Controller
public class SucursalController {
	
	@Autowired
	private ISucursalService sucursalServ;
	
	@Autowired
	private IPaisService paisServ;
	

	@GetMapping("/")
	public String homePage(){
		return "home";
	}
	//Muestra lista de Sucursales
	@GetMapping("/sucursal")
	public String listSucursales(Model model){
		model.addAttribute("titulo", "Lista de Sucursales");
		model.addAttribute("sucursales", sucursalServ.getAllSucursales());

		return "/views/sucursales/list-sucursales";
	}
	
	@GetMapping("/sucursal/add")
	public String showNewSucursalForm(Model model) {
		SucursalDto sucursal = new SucursalDto();
		List<Pais> paises = paisServ.listaPaises();
	
		model.addAttribute("titulo", "Agregar Sucursal");
		model.addAttribute("sucursal",sucursal);
		model.addAttribute("paises",paises);

		return "/views/sucursales/form-save-sucursal";
	}
	
	@PostMapping("/sucursal/save")
	public String saveSucursal(@ModelAttribute SucursalDto sucursalDto) {
		sucursalServ.saveSucursal(sucursalDto);
		System.out.println("Guardado");
				
		return "redirect:/sucursal";
	}


	

}
