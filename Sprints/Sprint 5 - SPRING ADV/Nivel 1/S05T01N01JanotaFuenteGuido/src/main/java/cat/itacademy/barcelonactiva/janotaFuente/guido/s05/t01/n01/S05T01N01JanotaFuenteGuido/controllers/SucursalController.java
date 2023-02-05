package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.domain.Pais;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services.IPaisService;
import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.services.ISucursalService;
import jakarta.validation.Valid;

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
		SucursalDto sucursalDto = new SucursalDto();
		List<Pais> paises = paisServ.listaPaises();
	
		model.addAttribute("titulo", "Agregar Sucursal");
		model.addAttribute("boton", "Guardar Sucursal");
		model.addAttribute("sucursal",sucursalDto);
		model.addAttribute("paises",paises);

		return "/views/sucursales/form-save-sucursal";
	}
	
	@PostMapping("/save")
	public String saveSucursal(@Valid @ModelAttribute SucursalDto sucursalDto,
								BindingResult result, Model model, RedirectAttributes msg ) {
		
		System.out.println(result.getAllErrors());

		if(result.hasErrors() || sucursalDto.getPaisSucursal()==null) {
			System.out.println(result.getAllErrors());
			List<Pais> paises = paisServ.listaPaises();  //SACAR DEL IF Y PONERLO FUERA??
			
			model.addAttribute("titulo", "Agregar Sucursal");
			model.addAttribute("boton", "Guardar Sucursal");
			model.addAttribute("sucursal",sucursalDto);
			model.addAttribute("paises",paises);
			
			System.out.println("Errores detectados en Formulario");
			msg.addFlashAttribute("error", "Verifica que todos los campos estén completos.");

			return "redirect:/sucursal/add";
		}
		
		sucursalServ.saveSucursal(sucursalDto);
		System.out.println("Sucursal guardada");
		msg.addFlashAttribute("success", "La sucursal se ha guardado correctamente.");

				
		return "redirect:/sucursal";
	}
	
	@GetMapping("/{id}")
	public String showSucursal(@PathVariable("id") long id, Model model, RedirectAttributes msg) {
		SucursalDto sucursalDto = sucursalServ.getOneSucursal(id);
		
		if(sucursalDto!=null) {
			model.addAttribute("titulo", "Sucursal Encontrada");
			model.addAttribute("sucursales", sucursalDto);
			return "/views/sucursales/list-sucursales";
		} else {
			System.out.println("No se encontro sucursal");
			msg.addFlashAttribute("error", "Los datos ingresados no coinciden con ninguna Sucursal en el sistema.");
		}
		
		return "redirect:/sucursal";

	}

	//AGREGAR IF-ELSE COMO EN 'showSucursal'
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
	
	//AGREGAR IF-ELSE COMO EN 'showSucursal'
	//AGREGAR NOMBRE DE SUCURSAL EN EL POP-UP DE CONFIRMACION??
	@GetMapping("/delete/{id}")
	public String deleteSucursal(@PathVariable("id") Long id, RedirectAttributes msg) {
		String nombreSucursal = sucursalServ.getOneSucursal(id).getNombreSucursal();
		sucursalServ.deleteSucursal(id);
		msg.addFlashAttribute("warning", "La sucursal '" + nombreSucursal+"' se ha eliminado.");

		return "redirect:/sucursal";
	
	}
	

}
