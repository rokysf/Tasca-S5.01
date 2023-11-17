package cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.monsiglesias.jordi.s05.t01.n01.model.services.ISucursalService;


@Controller
@RequestMapping("/sucursal")

public class SucursalController {

	@Autowired
	private ISucursalService sucursalservice;

	@GetMapping
	public String home() {
		return "redirect:/sucursal/getAll";
	}
	
	@GetMapping("/add")
	public String registroAddSucursal(Model modelo) {
		Sucursal sucursal = new Sucursal();
		modelo.addAttribute("sucursal", sucursal);
		return "crear_sucursal";
	}

	@PostMapping("/add")
	public String createSucursal(@ModelAttribute("sucursal") Sucursal sucursal) {
		sucursalservice.createSucursal(sucursal);
		return "redirect:/sucursal/getAll";
	}

	@GetMapping("/update")
	public String registroUpdateSucursal(@RequestParam("id") Integer id, Model modelo) {
		SucursalDTO sucursalDTO = sucursalservice.getSucursalById(id);
		Sucursal sucursal = new Sucursal();
		sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
	    sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
	    sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
	    modelo.addAttribute("sucursal", sucursal);
	    return "edit_sucursal";
	}
	
	@PostMapping("/update")
	public String updateSucursal(@ModelAttribute("sucursal") Sucursal sucursal) {
	    sucursalservice.updateSucursal(sucursal);
	    return "redirect:/sucursal/getAll";
	}
	
	@GetMapping("/getOne/{id}")
	public String getSucursalById(@PathVariable("id") Integer id, Model modelo) {
		modelo.addAttribute("sucursals", sucursalservice.getSucursalById(id));
		return "sucursals";

	}

	@GetMapping("/delete/{id}")
	public String deleteSucursalById(@PathVariable("id") Integer id) {
		sucursalservice.deleteSucursalById(id);
		return "redirect:/sucursal/getAll";

	}

	@GetMapping("/getAll")
	public String getAllSucursals(Model modelo) {
		modelo.addAttribute("sucursals", sucursalservice.getAllSucursals());
		return "sucursals";
	}
}