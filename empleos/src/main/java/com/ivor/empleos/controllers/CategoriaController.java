package com.ivor.empleos.controllers; // Declaración del paquete

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Importa la anotación @Controller
import org.springframework.ui.Model; // Importa la interfaz Model para pasar datos a la vista
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping; // Importa la anotación @RequestMapping
import org.springframework.web.bind.annotation.RequestMethod; // Importa la enum RequestMethod para especificar métodos HTTP
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ivor.empleos.model.Categoria;
import com.ivor.empleos.service.I_CategoriaService;

@Controller // Marca esta clase como un controlador de Spring MVC
@RequestMapping(value= "/categorias")
// Mapea las solicitudes HTTP Todas las solicitudes HTTP que comienzan con
// /categorias
// serán manejadas por esta clase. Esto define una ruta base para todos los
// métodos del controlador.
public class CategoriaController {


	@Autowired // this.categoriaService = new CategoriaServiceImpl();
	private I_CategoriaService categoriaService;



	// **************** /categorias/index **********
	// Maneja las solicitudes GET a "/categorias/index"
	@RequestMapping(value= "/index", method= RequestMethod.GET)


	public String mostrarIndex(Model model) {
		List<Categoria> categoria= this.categoriaService.buscarTodas (); // Obtiene la lista de vacantes

		model.addAttribute ("_categorias", categoria);

		return "categorias/listCategorias"; // Retorna el nombre de la vista para mostrar la lista de categorías
	}



	// **************** /categorias/create **********
	// Maneja las solicitudes GET a "/categorias/create"
	@RequestMapping(value= "/create", method= RequestMethod.GET)
	public String crear(Categoria categoria) {
		return "categorias/formCategorias"; // Retorna el nombre de la vista para crear una nueva categoría
	}





	// **************** /categorias/save **********
	// Maneja las solicitudes POST a "/categorias/save"
	@RequestMapping(value= "/save", method= RequestMethod.POST)
	/*
	 * public String guardar(@RequestParam("nombre") String
	 * nombre, @RequestParam("descripcion") String descripcion) {
	 * System.out.println ("Categoria: " + categoria.getNombre ()); // Imprime el nombre de la
	 * categoría en la consola
	 * System.out.println ("Descripción: " + categoria.getDescripcion ()); // Imprime la
	 * descripción de la categoría en la consola
	 * return "categorias/listCategorias"; // Retorna el nombre de la vista para
	 * mostrar la lista de categorías
	 * }
	 */

	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes atributoRedirec) {
		System.out.println ("Categoria: " + categoria.getNombre ()); // Imprime el nombre de la categoría en la consola
		System.out.println ("Descripción: " + categoria.getDescripcion ()); // Imprime la descripción de la categoría en la consola



		// Modificación comienza aquí
		// Verifica si hay errores en la validación del objeto 'categoria'
		if (result.hasErrors ()){
			System.out.println ("Errores globales:");
			result.getGlobalErrors ().forEach (error-> {
				System.out.println ("Error: " + error.getDefaultMessage ());
			});


			// Verifica si hay errores específicos
			if (result.hasFieldErrors ()){
				System.out.println ("Errores en campos específicos:");
				result.getFieldErrors ().forEach (error-> {
					System.out.println ("Campo: " + error.getField () + ", Error Objeto: " + error.getObjectName () + ", Error Code: " + error.getCode ());
				});
			}
			return "redirect:/categorias/index";// Si hay errores, vuelve al formulario para formCategorias
		}

		// Imprime la información del objeto 'Vacante' en la consola
		System.out.println ("Nombre Categoria (/vacantes/save) :" + categoria);
		System.out.println ();

		// Guarda el objeto 'Vacante' utilizando el servicio
		this.categoriaService.guardar (categoria);

		// Añadir un mensaje de éxito usando Flash Attributes
		atributoRedirec.addFlashAttribute ("registroGuardado", "¡Registro guardada con éxito!");


		// Devuelve la vista "vacante/formVacante"' después de guardar la información
		return "redirect:/categorias/index";// Se realiza en forma indirecta petición http tipo Get a /categorias/index
	}
}



















