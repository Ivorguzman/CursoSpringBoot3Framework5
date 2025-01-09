package com.ivor.empleos.controllers;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


	// **************** /vacantes/create **********
	@GetMapping("/create")
	public String crear() {

		return "vacante/formVacante";
	};





	/*
	 * 
	 * // **** /vacantes/save (Usando la Anotación @RequestParam()) ******
	 * 
	 * Aqui (Usando @RequestParam): Cada campo del formulario se
	 * captura individualmente a través de los parámetros del método usando la
	 * anotación @RequestParam. Esto significa que cada valor del formulario se
	 * asigna a una variable individual.
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
	 * 
	 * 
	 * Aqui (Usando Objeto Vacante): <<El formulario completo>> se
	 * vincula a un objeto Vacante. Los datos del formulario se asignan
	 * automáticamente a los campos correspondientes del objeto Vacante gracias
	 * al data binding de Spring MVC.
	 * <<Diferencias Clave en el Enfoque de Captura de Datos.>>
	 * 
	 * //<< /vacantes/save (Usando como parametro un Objeto tipo Vacante) >>
	 */
	@PostMapping("/save") // La anotacion Real
	public String guardar(Vacante vacante) {

		// Aquí se realiza el data binding:
		// Spring MVC automáticamente vincula los datos del formulario HTML a los
		// campos del objeto 'Vacante'.
		// Esto se logra porque los nombres de los campos del formulario coinciden
		// con los nombres de los atributos en la clase 'Vacante'.
		System.out.println ("Nombre Vacante :" + vacante); // Imprime la información del objeto 'Vacante' en la consola

		return "vacante/listVacantes"; // Devuelve la vista 'listVacantes' después de guardar la información
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





























