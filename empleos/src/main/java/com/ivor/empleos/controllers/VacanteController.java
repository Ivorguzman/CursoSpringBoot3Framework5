package com.ivor.empleos.controllers;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ivor.empleos.model.Vacante;
import com.ivor.empleos.service.I_CategoriaService;
import com.ivor.empleos.service.I_VacanteService;
import com.ivor.empleos.util.Utileria;



@Controller
@RequestMapping("/vacantes") // Marca esta clase como un controlador de Spring MVC
public class VacanteController {


	@Value("${empleos.ruta.imagenes}")
	private String ruta;

	/*
	 * _____ Todos los pasos Ahorrados _______
	 * CategoriaServiceImp categoriaInyectar= new CategoriaServiceImp ();
	 * private I_CategoriaService serviceCategoria= this.categoriaInyectar;
	 */
	@Autowired // this.serviceCategoria = new CategoriaServiceImp();
	private I_CategoriaService serviceCategoria;



	/*
	 * _____ Todos los pasos Ahorrados _______
	 * CategoriaServiceImp serviceInyectar= new CategoriaServiceImp ();
	 * private I_CategoriaService serviceVacantes= this.serviceInyectar;
	 * 
	 * Se utiliza la anotación @Autowired para inyectar una dependencia de la interfaz I_VacanteService en el controlador
	 * VacanteController. Esto significa que Spring automáticamente proporcionará una implementación de esta interfaz (como
	 * VacanteServiceImpl) al atributo serviceVacantes en tiempo de ejecución. Esto elimina la necesidad de crear
	 * manualmente una instancia de la clase de servicio.
	 */
	@Autowired
	private I_VacanteService serviceVacantes;





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
	 * WebDataBinder.registerCustomEditor(Date.class, new
	 * CustomDateEditor(dateFormat, false));:
	 * 
	 * WebDataBinder.registerCustomEditor: Este método se utiliza para
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
	 * }
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}



	// @PostMapping("/index")
	@GetMapping("/index")
	public String mostrarIndex(Model modelo) {

		List<Vacante> lista = this.serviceVacantes.buscarTodasVacante(); // Obtiene la lista de vacantes

		// para depuración
		System.out.println();
		System.out.println("(/index) VacanteController [buscarTodasVacante()] - listvacantes.html ==> " + lista); // Imprime la lista
		modelo.addAttribute("_vacantes", lista); // Añade la lista de vacantes al modelo
		return "vacante/listvacantes"; // Devuelve la vista 'listVacantes' después de guardar la información
	}



	// **************** /vacantes/create **********

	// Maneja solicitudes GET para la ruta "/create".
	// Este método prepara el modelo para la vista "formVacantes".
	// Se utiliza para mostrar un formulario para crear una nueva vacante.

	// Parámetros:
	// - Vacante vacante: Un objeto vacío que será llenado con los datos del formulario.
	// - Model model: Objeto utilizado para pasar datos desde el controlador a la vista.

	// Funcionalidad:
	// - Obtiene la lista de categorías mediante el servicio `serviceCategoria.buscarTodas()`.
	// - Imprime la lista de categorías en la consola para depuración.
	// - Añade la lista de categorías al modelo con el nombre "categorias".
	// - Devuelve la vista "vacante/formVacantes" para mostrar el formulario.
	@GetMapping("/create")
	public String crear(Vacante vacante, Model model) {
		System.out.println("(/create) VacanteController [buscarTodas()] - formVacantes.html ==> " + this.serviceCategoria.buscarTodas());
		System.out.println();
		model.addAttribute("categorias", this.serviceCategoria.buscarTodas());
		return "vacante/formVacantes";
	}



	// Aquí se realiza el data binding:
	// Spring MVC automáticamente vincula los datos del formulario HTML a los
	// campos del objeto 'Vacante'.
	// Esto se logra porque los nombres de los campos del formulario coinciden
	// con los nombres de los atributos en la clase 'V
	// **************** /vacantes/save **********
	@PostMapping("/save")
	/*
	 * Vacante vacante
	 * Es un parámetro del método. Representa un objeto de tipo Vacante que contiene los datos de la vacante que se desea
	 * guardar. Spring MVC vincula automáticamente los datos del formulario HTML a este objeto.
	 *
	 * BindingResult result
	 * Es un objeto que contiene los resultados de la validación del objeto Vacante. Si hay errores en la validación, estos
	 * se almacenan en este objeto.
	 *
	 * RedirectAttributes atributoRedirec
	 * Es un objeto que permite agregar atributos que se envían en una redirección HTTP. Se utiliza para pasar mensajes o
	 * datos entre solicitudes.
	 * 
	 * @RequestParam("ArchivoImagen") MultipartFile multiPart
	 *
	 * @RequestParam: Es una anotación que indica que el parámetro multiPart se extrae de la solicitud HTTP.
	 * "ArchivoImagen": Es el nombre del parámetro en la solicitud HTTP que contiene el archivo subido.
	 * MultipartFile: Es una interfaz de Spring que representa un archivo subido. Permite acceder al contenido del archivo y
	 * realizar operaciones como guardarlo en el sistema de archivos.
	 * 
	 * 
	 * Funcionamiento del método:
	 * Recepción de datos:
	 * El objeto Vacante recibe los datos del formulario HTML.
	 * El archivo subido se recibe como un objeto MultipartFile.
	 * Validación:
	 * Se verifica si el objeto Vacante tiene errores de validación utilizando BindingResult.
	 * Si hay errores, se imprimen en la consola y se retorna la vista del formulario para corregirlos.
	 * Procesamiento del archivo:
	 * Si el archivo subido no está vacío (!multiPart.isEmpty()), se guarda en el sistema de archivos utilizando una
	 * utilidad (Utileria.guardarArchivo).
	 * El nombre del archivo se asigna al atributo images del objeto Vacante.
	 * Guardado de la vacante:
	 * Se utiliza el servicio serviceVacantes para guardar el objeto Vacante en la base de datos.
	 * Redirección:
	 * Se agrega un mensaje de éxito a los atributos de redirección (atributoRedirec.addFlashAttribute).
	 * Se redirige a la vista /vacantes/index.
	 */
	public String guardar(Vacante vacante, BindingResult result, RedirectAttributes atributoRedirec, @RequestParam("ArchivoImagen") MultipartFile multiPart) {
		if (result.hasErrors()){

			if (result.hasGlobalErrors()){
				System.out.println("Errores globales:");
				result.getGlobalErrors().forEach(error-> {
					System.out.println("Error: " + error.getDefaultMessage());
				});

			}
			// Verifica si hay errores específicos
			if (result.hasFieldErrors()){
				System.out.println("Errores en campos específicos:");
				result.getFieldErrors().forEach(error-> {
					System.out.println("Campo: " + error.getField() + ", Error Objeto: " + error.getObjectName() + ", Error Code: " + error.getCode());
				});
			}

			return "vacante/formVacantes"; // Si hay errores, vuelve al formulario para formVacantes

		}







		/*
		 * MultipartFile es una interfaz proporcionada por Spring para manejar
		 * archivos subidos. Este tipo de dato permite que el controlador reciba el
		 * archivo en su forma binaria, que luego puede ser guardada en el sistema de
		 * archivos, una base de datos, o procesada de otra manera según sea necesario.
		 */
		if (!multiPart.isEmpty()){
			// String ruta = "C:/empleos/img-vacantes";
			String nombreImagen = Utileria.guardarArchivo(multiPart, this.ruta);
			System.out.println("nombreImagen= " + nombreImagen);
			System.out.println("multiPart= " + multiPart);
			System.out.println("ruta= " + this.ruta);
			if (nombreImagen != null){
				vacante.setImages(nombreImagen);
			}
		}
		// Imprime la información del objeto 'Vacante' en la consola
		System.out.println("Nombre Vacante (/vacantes/save) :" + vacante);
		System.out.println();


		// Guarda el objeto 'Vacante' utilizando el servicio
		this.serviceVacantes.guardar(vacante);
		// Añadir un mensaje de éxito usando Flash Attributes
		atributoRedirec.addFlashAttribute("registroGuardado", "¡Registro guardada con éxito!");


		// Devuelve la vista "vacante/formVacante"' después de guardar la información
		return "redirect:/vacantes/index";// Se realiza en forma indirecta petición http tipo Get (vacantes/listVacante)

	}





	// **************** /vacantes/delete?id=X (parametro enviadado via http con
	// @RequestParam("id")) ******************************
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model modelo) {
		modelo.addAttribute("id", idVacante);
		System.out.println("Borrando vacantes con id: " + idVacante);
		return "/mensaje";
	}


	// **** /vacantes/viewdetalles/X (parametro enviadado via http con
	// @PathVariable("id")) ****

	@GetMapping("/viewdetalles/{id}")
	// Esta anotación indica que este método manejará solicitudes HTTP GET
	// dirigidas a la ruta "/viewdetalles/{id}". El "{id}" es un parámetro dinámico
	// que se extraerá de la URL y se pasará al método como argumento.


	public String verDetalleVacante(@PathVariable("id") int idVacante, Model modelo) {
		// Define un método público que devuelve un String, el cual representa el nombre
		// de la vista que se debe renderizar. El parámetro "@PathVariable("id")" indica
		// que el valor del parámetro "id" en la URL será asignado a la variable "idVacante".
		// El parámetro "Model modelo" se utiliza para pasar datos desde el controlador
		// a la vista.

		Vacante vacante = this.serviceVacantes.buscarVarPorIdVacante(idVacante);
		// Se llama al método "buscarVarPorIdVacante" del servicio "serviceVacantes"
		// para buscar una vacante específica en base al "idVacante" proporcionado.
		// El resultado se almacena en la variable "vacante".

		System.out.println("Detalle de vacante: " + vacante);
		// Imprime en la consola el detalle de la vacante obtenida, lo que es útil
		// para depuración y verificar que se obtuvo correctamente la información

		modelo.addAttribute("vacante", vacante);
		// Se agrega la vacante obtenida al objeto "modelo" con el nombre "vacante".
		// Esto permite que la información de la vacante esté disponible en la vista
		// que se renderizará.

		return "/vacante/detalleVacantes";
		// Se agrega la vacante obtenida al objeto "modelo" con el nombre "vacante".
		// Esto permite que la información de la vacante esté disponible en la vista
		// que se renderizará.
	}



	// **************** /vacantes/prueba **********
	// con @PathVariable("id")) ******************************
	@GetMapping("/prueba")
	public String pruebaHtml(Model modelo) {

		modelo.addAttribute("hola");
		return "/home_ofertaTrabajo";
	}







	// **************** /vacantes/view/X (parametro enviadado via http con
	// @PathVariable("id")) ******************************
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model modelo) {

		Vacante vacante = this.serviceVacantes.buscarVarPorIdVacante(idVacante);
		System.out.println("Detalle de vacante: " + vacante);

		modelo.addAttribute("vacante", vacante);
		return "detalle";
	}


}


