package com.ivor.empleos.controllers;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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


	/*
	 * // **************** /vacantes/create **********
	 * 
	 * @GetMapping("/create")
	 * public String crear() {
	 * 
	 * return "vacante/formVacante";
	 * };
	 */

	@GetMapping("/create")
	public String crear(Vacante vacante) {
		return "vacante/formVacante";
	}


// Aquí se realiza el data binding:
// Spring MVC automáticamente vincula los datos del formulario HTML a los
// campos del objeto 'Vacante'.
// Esto se logra porque los nombres de los campos del formulario coinciden
// con los nombres de los atributos en la clase 'V
	@PostMapping("/save")
	public String guardar(Vacante vacante, BindingResult result, Model model) {

		// Modificación comienza aquí
		// Verifica si hay errores en la validación del objeto 'Vacante'
		if (result.hasErrors ()){

			// Verifica si hay errores globales
			if (result.hasGlobalErrors ()){
				System.out.println ("Errores globales:");
				result.getGlobalErrors ().forEach (error-> {
					System.out.println ("Error: " + error.getDefaultMessage ());
				});

			}
			// Verifica si hay errores específicos
			if (result.hasFieldErrors ()){
				System.out.println ("Errores en campos específicos:");
				result.getFieldErrors ().forEach (error-> {
					System.out.println ("Campo: " + error.getField () + ", Error Objeto: " + error.getObjectName () + ", Error Code: " + error.getCode ());
				});
			}

			return "vacante/formVacante"; // Si hay errores, vuelve al formulario para corregirlos
		}
		// Modificación termina aquí

		// Imprime la información del objeto 'Vacante' en la consola
		System.out.println ("Nombre Vacante (/vacantes/save) :" + vacante);
		System.out.println ();

		// Guarda el objeto 'Vacante' utilizando el servicio
		this.serviceVacantes.guardar (vacante);

		// Devuelve la vista "vacante/formVacante"' después de guardar la
		// información
		return "redirect:/vacantes/index";// Se realiza en forma indirecta petición http tipo Get
												// (vacantes/listVacante)

	}





	// @PostMapping("/index")
	@GetMapping("/index")
	public String mostrarIndex(Model modelo) {

		List<Vacante> lista= this.serviceVacantes.buscarTodasVacante (); // Obtiene la lista de vacantes
		// System.out.println();
		// System.out.println("lista_VariableLocal = " + lista); // Imprime la lista
		// para depuración
		modelo.addAttribute ("vacantes", lista); // Añade la lista de vacantes al modelo
		return "vacante/listvacantes"; // Devuelve la vista 'listVacantes' después de guardar la información
	}




	/*
	 * Explicación Línea por Línea
	 * 
	 * @InitBinder:
	 * 
	 * @InitBinder es una anotación en Spring MVC que se usa para inicializar
	 * datos relacionados con la web. Permite personalizar la forma en que los
	 * datos de los formularios web son vinculados a objetos de la aplicación.
	 * 
	 * En otras palabras, sirve para configurar cómo se procesan los datos
	 * recibidos en las solicitudes web antes de que se vinculen a los objetos
	 * del controlador.
	 * 
	 * public void initBinder(WebDataBinder _WebDataBinder):
	 * 
	 * public: Indica que este método es accesible desde cualquier parte del
	 * programa.
	 * 
	 * void: Significa que este método no devuelve ningún valor.
	 * 
	 * initBinder: Es el nombre del método. Podrías llamarlo como quieras, pero
	 * "initBinder" es comúnmente utilizado para indicar que se está
	 * inicializando un Binder.
	 * 
	 * WebDataBinder _WebDataBinder: El parámetro WebDataBinder es un objeto
	 * proporcionado por Spring MVC que ayuda a gestionar la conversión y
	 * validación de datos de las solicitudes web.
	 * 
	 * SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");:
	 * 
	 * SimpleDateFormat: Es una clase en Java que se utiliza para formatear y
	 * analizar fechas.
	 * 
	 * dateFormat: Es el nombre de la variable. Aquí estamos creando una
	 * instancia de SimpleDateFormat.
	 * 
	 * new SimpleDateFormat("dd-MM-yyyy"): Estamos creando un nuevo objeto
	 * SimpleDateFormat con el patrón de fecha "dd-MM-yyyy", lo que significa
	 * que la fecha se espera en el formato día-mes-año.
	 * 
	 * _WebDataBinder.registerCustomEditor(Date.class, new
	 * CustomDateEditor(dateFormat, false));:
	 * 
	 * _WebDataBinder.registerCustomEditor: Este método se utiliza para
	 * registrar un editor personalizado para un tipo específico de datos.
	 * 
	 * Date.class: Especifica que queremos registrar un editor personalizado
	 * para el tipo de datos Date.
	 * 
	 * new CustomDateEditor(dateFormat, false): Aquí estamos creando una nueva
	 * instancia de CustomDateEditor.
	 * 
	 * dateFormat: Pasamos nuestro objeto SimpleDateFormat que define el formato
	 * de fecha.
	 * 
	 * false: Este parámetro booleano indica si la propiedad de fecha es
	 * obligatoria o no. false significa que no es obligatorio.
	 * 
	 * Resumen del Funcionamiento
	 * La anotación @InitBinder se usa para personalizar la forma en que los
	 * datos del formulario web son procesados y convertidos.
	 * 
	 * El método initBinder se utiliza para configurar el WebDataBinder y
	 * registrar un editor personalizado para el tipo Date.
	 * 
	 * Se crea un formato de fecha específico usando SimpleDateFormat.
	 * 
	 * Se registra el CustomDateEditor para manejar la conversión de cadenas de
	 * texto en objetos Date utilizando el formato de fecha especificado.
	 * 
	 * Ejemplo de Uso
	 * Imagina que tienes un formulario web donde el usuario ingresa una fecha
	 * en el formato "dd-MM-yyyy". Cuando este formulario se envía, Spring MVC
	 * usará el método initBinder para asegurarse de que la cadena de texto de
	 * la fecha se convierta correctamente en un objeto Date de acuerdo con el
	 * formato especificado.
	 */


	/*
	 * @InitBinder
	 * public void initBinder(WebDataBinder _WebDataBinder) {
	 * SimpleDateFormat dateFormat= new SimpleDateFormat ("dd-MM-yyy");
	 * _WebDataBinder.registerCustomEditor (Date.class, new CustomDateEditor
	 * (dateFormat, false));
	 * };
	 */




	@InitBinder
	public void initBinder(WebDataBinder _WebDataBinder) {
		// Creación del formato de fecha
		SimpleDateFormat dateFormat= new SimpleDateFormat ("dd-MM-yyyy");
		dateFormat.setLenient (false); // Establecer que el análisis de fechas debe ser estricto
		// Registrar el editor personalizado para el tipo Date
		_WebDataBinder.registerCustomEditor (Date.class, new CustomDateEditor (dateFormat, false));

	}
































	// ------<<EJEMPLOS DE CLASES QUE NO QUIERO BORRAR>>-----

	// **** /vacantes/viewdetalles/X (parametro enviadado via http con
	// @PathVariable("id")) ****
	/**
	 * @param idVacante
	 * @param modelo
	 * @return
	 */
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





























