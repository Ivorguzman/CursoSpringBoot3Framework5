package com.ivor.empleos.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/vacantes")
public class VacanteController {


	// **************** /vacantes/view/X ******************************
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model modelo) {
		modelo.addAttribute("idVacante", idVacante);
		System.out.println();
		return "/vacante/detalle";
	}



	// **************** /vacantes/delete?id=X ******************************
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model modelo) {
		modelo.addAttribute("id", idVacante);
		System.out.println("Borrando vacantes con id: " + idVacante);
		return "/mensaje";
	}


}





























