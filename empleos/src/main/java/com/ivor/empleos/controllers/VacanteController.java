package com.ivor.empleos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ivor.empleos.model.Vacante;
import com.ivor.empleos.service.I_Vacanteservice;



@Controller
@RequestMapping("/vacantes")
public class VacanteController {
	@Autowired // this.serviceVacantes = new VacanteServiceImpl();
	private I_Vacanteservice serviceVacantes;


	// **************** /vacantes/create **********
	@GetMapping("/create")
	public String crear() {

		return "vacante/formVacante";
	};



	// **** /vacantes/save (Usando como parametro un bjeto tipo Vacante) ******
	@PostMapping("/save") // La anotacion Real
	public String guardar(Vacante vacante) {

		System.out.println ("Nombre Vacante :" + vacante);

		return "vacante/listVacantes";
	}





	/*
	 * 
	 * // **** /vacantes/save (Usando la Anotación @RequestParam()) ******
	 * 
	 * @PostMapping("/save") // La anotacion Real
	 * public String guardar(@RequestParam("nombre") String nombre,
	 * 
	 * @RequestParam("descripcion") String descripcion,
	 * 
	 * @RequestParam("fecha") String fecha,
	 * 
	 * @RequestParam("salario") Double salario,
	 * 
	 * @RequestParam("destacado") int destacado,
	 * 
	 * @RequestParam("status") String status,
	 * 
	 * @RequestParam("detalles") String detalles) {
	 * 
	 * System.out.println ("Nombre Vacante :" + nombre);
	 * System.out.println ("Nombre descripcion :" + descripcion);
	 * System.out.println ("Nombre fecha :" + fecha);
	 * System.out.println ("Nombre salario :" + salario);
	 * System.out.println ("Nombre destacado :" + destacado);
	 * System.out.println ("Nombre status :" + status);
	 * System.out.println ("Nombre detalles :" + detalles);
	 * 
	 * return "vacante/listVacantes";
	 * }
	 * 
	 */



	// **** /vacantes/viewdetalles/X (parametro enviadado via http con
	// @PathVariable("id")) ****
	@GetMapping("/viewdetalles/{id}")
	public String verDetalleVacante(@PathVariable("id") int idVacante, Model modelo) {

		Vacante vacante= this.serviceVacantes.buscarVarPorIdVacante (idVacante);
		System.out.println ("Detalle de vacante: " + vacante);

		modelo.addAttribute ("vacante", vacante);
		return "/vacante/detalleVacante";
	}



	// **************** /vacantes/prueba **********
	// con @PathVariable("id")) ******************************
	@GetMapping("/prueba")
	public String pruebaHtml(Model modelo) {

		modelo.addAttribute ("hola");
		return "/home_ofertaTrabajo";
	}







	// **************** /vacantes/view/X (parametro enviadado via http con
	// @PathVariable("id")) ******************************
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model modelo) {

		Vacante vacante= this.serviceVacantes.buscarVarPorIdVacante (idVacante);
		System.out.println ("Detalle de vacante: " + vacante);

		modelo.addAttribute ("vacante", vacante);
		return "detalle";
	}






	// **************** /vacantes/delete?id=X (parametro enviadado via http con
	// @RequestParam("id")) ******************************
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model modelo) {
		modelo.addAttribute ("id", idVacante);
		System.out.println ("Borrando vacantes con id: " + idVacante);
		return "/mensaje";
	}


}





























