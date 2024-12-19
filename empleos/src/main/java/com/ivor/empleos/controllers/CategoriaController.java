package com.ivor.empleos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// ********************** /categorias *****************************
@Controller
@RequestMapping(value = "/categorias")
public class CategoriaController {


	// ********************** /categorias/index *****************************
	// @GetMapping("/index")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mostrarIndex(Model model) {

		return "categorias/listCategorias";

	}


	// ********************** /categorias/create *****************************
	// @GetMapping("/create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)

	public String crear() {

		return "categorias/formCategoria";

	}


	// ********************** /categorias /save *****************************
	// @GetMapping("/save")
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String guardar() {

		return "categorias/listCategorias";

	}

}
