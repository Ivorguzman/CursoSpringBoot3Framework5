// ****************** PAQUETE ******************

// package com.ivor.empleos.controllers;
// - Define el paquete en el que se encuentra este controlador dentro del proyecto.
// - Ayuda a organizar el código en módulos específicos, facilitando su mantenimiento.
package com.ivor.empleos.controllers;

// ****************** IMPORTACIÓN DE CLASES ******************

// import java.util.List;
// - Importa la interfaz `List`, que permite manejar listas de elementos.
// - Se usará para almacenar múltiples objetos `Categoria`.
import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// - Importa la anotación `@Autowired`, que permite la **inyección de dependencias** en Spring.
// - Spring usa esta anotación para **instanciar automáticamente** la implementación del servicio `I_CategoriaService`.
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// - Importa la anotación `@Controller`, que indica que esta clase es un **controlador** de Spring MVC.
// - En Spring MVC, los controladores manejan **solicitudes HTTP** y devuelven **vistas** o datos.
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// - Importa la interfaz `Model`, que permite **pasar datos** desde el controlador a la vista.
// - Se usa para agregar atributos a la vista, como listas de categorías.
import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// - Importa `BindingResult`, que se usa para **validar** el objeto `Categoria` antes de guardarlo.
// - Permite detectar errores en el formulario y devolver mensajes de validación.
import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.RequestMapping;
// - Importa `@RequestMapping`, que permite **asociar URLs** con métodos del controlador.
// - Se usa para definir **rutas HTTP** que manejará cada método.
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// - Importa `RequestMethod`, que define los **métodos HTTP** (GET, POST, etc.).
// - Se usa dentro de `@RequestMapping` para especificar cómo se accede a cada ruta.
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;
// - Importa `RedirectAttributes`, que permite **redireccionar peticiones** después de ejecutar acciones.
// - Se usa para enviar mensajes de éxito al redireccionar a otra página.
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// import com.ivor.empleos.model.Categoria;
// - Importa la clase `Categoria`, que representa una categoría de empleo.
// - Se usa en los métodos de este controlador para manejar categorías.
import com.ivor.empleos.model.Categoria;
// import com.ivor.empleos.service.I_CategoriaService;
// - Importa la interfaz `I_CategoriaService`, que define los métodos para manejar categorías.
// - Se usará en este controlador para **interactuar con el servicio de categorías**.
import com.ivor.empleos.service.I_CategoriaService;

// ****************** DEFINICIÓN DEL CONTROLADOR ******************

// @Controller
// - Declara que esta clase es un **controlador de Spring MVC**.
// - Spring la gestiona automáticamente y la usa para manejar **peticiones HTTP**.
@Controller

// @RequestMapping(value="/categorias")
// - Define una **ruta base** para todas las peticiones manejadas por este controlador.
// - Todas las URLs que comiencen con `/categorias` serán procesadas por los métodos de esta clase.
@RequestMapping(value = "/categorias")
public class CategoriaController { // Declaramos la clase pública `CategoriaController`

	// ****************** INYECCIÓN DE DEPENDENCIA ******************

	// @Autowired
	// - Spring **inyecta automáticamente** una instancia de `I_CategoriaService` en este atributo.
	// - Gracias a esto, podemos usar los métodos del servicio sin tener que instanciarlo manualmente.
	@Autowired
	private I_CategoriaService categoriaService;

	// ****************** MÉTODO PARA MOSTRAR TODAS LAS CATEGORÍAS ******************

	// @RequestMapping(value="/index", method=RequestMethod.GET)
	// - Define que este método maneja **solicitudes GET** a la URL `/categorias/index`.
	// - Cuando un usuario acceda a `/categorias/index`, se ejecutará `mostrarIndex()`.
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mostrarIndex(Model model) { // Método que maneja la visualización de categorías objeto. (Model model)es un objeto permite enviar datos desde el
												 // controlador
												 // hacia la vista.

		// this.categoriaService.buscarTodas();
		// - Llama al servicio `categoriaService` para obtener todas las categorías de la base de datos.
		List<Categoria> categorias = this.categoriaService.buscarTodas();

		// model.addAttribute("_categorias", categorias);
		// - Agrega la lista de categorías al modelo, para que la vista pueda mostrarla.
		model.addAttribute("_categorias", categorias);

		// return "categorias/listCategorias";
		// - Retorna el nombre de la vista que mostrará la lista de categorías.
		return "categorias/listCategorias";
	}

	// ****************** MÉTODO PARA MOSTRAR EL FORMULARIO DE CREACIÓN ******************

	// @RequestMapping(value="/create", method=RequestMethod.GET)
	// - Define que este método maneja **solicitudes GET** a la URL `/categorias/create`.
	// - Cuando un usuario acceda a `/categorias/create`, se ejecutará `crear()`.
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String crear(Categoria categoria) { // Método para mostrar el formulario de creación
		return "categorias/formCategorias"; // Retorna la vista donde se crea una nueva categoría.
	}

	// ****************** MÉTODO PARA GUARDAR UNA CATEGORÍA ******************

	// @RequestMapping(value="/save", method=RequestMethod.POST)
	// - Define que este método maneja **solicitudes POST** a la URL `/categorias/save`.
	// - Se ejecutará cuando un usuario envíe el formulario de creación o edición de categoría.
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes atributoRedirec) {

		// System.out.println ("Categoria: " + categoria.getNombre());
		// - Imprime el nombre de la categoría ingresada en el formulario.
		System.out.println("Categoria: " + categoria.getNombre());

		// System.out.println ("Descripción: " + categoria.getDescripcion());
		// - Imprime la descripción de la categoría ingresada en el formulario.
		System.out.println("Descripción: " + categoria.getDescripcion());

		// ****************** VALIDACIÓN DE DATOS ******************

		// if (result.hasErrors()) {...}
		// - Si el objeto `categoria` tiene errores de validación, se detectarán aquí.
		if (result.hasErrors()){

			// Muestra los errores globales en la consola
			System.out.println("Errores globales:");
			result.getGlobalErrors().forEach(error-> {
				System.out.println("Error: " + error.getDefaultMessage());
			});

			// Muestra los errores de campos específicos
			if (result.hasFieldErrors()){
				System.out.println("Errores en campos específicos:");
				result.getFieldErrors().forEach(error-> {
					System.out.println("Campo: " + error.getField() + ", Error: " + error.getDefaultMessage());
				});
			}

			// Redirige al formulario si hay errores
			return "redirect:/categorias/index";
		}

		// Guarda la nueva categoría en la base de datos usando el servicio
		this.categoriaService.guardar(categoria);

		// Añade un mensaje de éxito al redireccionar
		atributoRedirec.addFlashAttribute("registroGuardado", "¡Registro guardado con éxito!");

		// Redirige al listado de categorías después de guardar
		return "redirect:/categorias/index";
	}

	/*
	 * 🚀 Conclusión
	 * Este controlador maneja la gestión de categorías en Spring Boot, permitiendo listar, crear y guardar categorías de
	 * empleo. Usa Spring MVC para manejar solicitudes HTTP, validaciones y vistas.
	 * 
	 */

}
