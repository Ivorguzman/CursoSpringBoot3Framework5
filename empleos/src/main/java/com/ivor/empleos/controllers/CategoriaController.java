package com.ivor.empleos.controllers; // Declaración del paquete

import org.springframework.stereotype.Controller; // Importa la anotación @Controller
import org.springframework.ui.Model; // Importa la interfaz Model para pasar datos a la vista
import org.springframework.web.bind.annotation.RequestMapping; // Importa la anotación @RequestMapping
import org.springframework.web.bind.annotation.RequestMethod; // Importa la enum RequestMethod para especificar métodos HTTP
import org.springframework.web.bind.annotation.RequestParam; // Importa la anotación @RequestParam para capturar parámetros

@Controller // Marca esta clase como un controlador de Spring MVC
@RequestMapping(value = "/categorias") 
// Mapea las solicitudes HTTP Todas las solicitudes HTTP que comienzan con /categorias
// serán manejadas por esta clase. Esto define una ruta base para todos los métodos del controlador.
public class CategoriaController {

	// Maneja las solicitudes GET a "/categorias/index"
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mostrarIndex(Model model) {
		return "categorias/listCategorias"; // Retorna el nombre de la vista para mostrar la lista de categorías
	}

	// Maneja las solicitudes GET a "/categorias/create"
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String crear() {
		return "categorias/formCategoria"; // Retorna el nombre de la vista para crear una nueva categoría
	}

	// Maneja las solicitudes POST a "/categorias/save"
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
		System.out.println("Categoria: " + nombre); // Imprime el nombre de la categoría en la consola
		System.out.println("Descripción: " + descripcion); // Imprime la descripción de la categoría en la consola
		return "categorias/listCategorias"; // Retorna el nombre de la vista para mostrar la lista de categorías
	}
}



















