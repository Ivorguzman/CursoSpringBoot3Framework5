package com.ivor.empleos.controllers;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


	@GetMapping("/listado")
	public String mostrarListado(Model modelo) {

		List<String> lista = new LinkedList<>();
		lista.add("Ingeniero de SoftWare");
		lista.add("Auxiliar Contable");
		lista.add("Técnico en PCs");
		lista.add("Arquitecto");

		modelo.addAttribute("empleos", lista);

		return "listado";
	}




	@GetMapping("/")
	public String mostrarHome(Model modelo) {
		String nombre = "Auxiliar contable";
		Date fechaPublicacion = new Date();
		double salario = 9000.0;
		boolean vigente = true;

		modelo.addAttribute("nombre", nombre);
		modelo.addAttribute("fechaPublicacion", fechaPublicacion);
		modelo.addAttribute("salario", salario);
		modelo.addAttribute("vigente", vigente);

		return "home";
	}
}
