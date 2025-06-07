// ****************** PAQUETE ******************

// package com.ivor.empleos.controllers;
// - Define el paquete donde se encuentra este controlador dentro del proyecto.
// - Los paquetes ayudan a organizar el código en módulos específicos, facilitando su mantenimiento.
package com.ivor.empleos.controllers;

// ****************** IMPORTACIÓN DE CLASES ******************

// import java.util.Date;
// - Importa la clase `Date`, que permite manejar fechas en Java.
// - Se usará para asignar fechas a las vacantes.
import java.util.Date;
// import java.util.LinkedList;
// - Importa `LinkedList`, una implementación de la interfaz `List` en Java.
// - Se usa para almacenar objetos `Vacante` en una lista enlazada.
import java.util.LinkedList;
// import java.util.List;
// - Importa la interfaz `List`, que define una estructura de lista en Java.
// - `LinkedList` implementa `List`, lo que permite su uso en el código.
import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// - Importa la anotación `@Autowired`, que permite la **inyección de dependencias** en Spring.
// - Spring usa esta anotación para **instanciar automáticamente** la implementación del servicio `I_VacanteService`.
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// - Importa la anotación `@Controller`, que indica que esta clase es un **controlador** de Spring MVC.
// - En Spring MVC, los controladores manejan **solicitudes HTTP** y devuelven **vistas** o datos.
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// - Importa la interfaz `Model`, que permite **pasar datos** desde el controlador a la vista.
// - Se usa para agregar atributos a la vista, como listas de vacantes.
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// - Importa `@GetMapping`, que define métodos que manejan **solicitudes GET** en Spring MVC.
// - Se usa para asociar rutas HTTP con métodos del controlador.
import org.springframework.web.bind.annotation.GetMapping;

// import com.ivor.empleos.model.Vacante;
// - Importa la clase `Vacante`, que representa una oferta de empleo.
// - Se usará en los métodos de este controlador para manejar vacantes.
import com.ivor.empleos.model.Vacante;
// import com.ivor.empleos.service.I_VacanteService;
// - Importa la interfaz `I_VacanteService`, que define los métodos para manejar vacantes.
// - Se usará en este controlador para **interactuar con el servicio de vacantes**.
import com.ivor.empleos.service.I_VacanteService;

// ****************** DEFINICIÓN DEL CONTROLADOR ******************

// @Controller
// - Declara que esta clase es un **controlador de Spring MVC**.
// - Spring la gestiona automáticamente y la usa para manejar **peticiones HTTP**.
@Controller
public class HomeController { // Declaramos la clase pública `HomeController`

	// ****************** INYECCIÓN DE DEPENDENCIA ******************

	// @Autowired
	// - Spring **inyecta automáticamente** una instancia de `I_VacanteService` en este atributo.
	// - Gracias a esto, podemos usar los métodos del servicio sin tener que instanciarlo manualmente.
	@Autowired
	private I_VacanteService serviceVacantes;

	// ****************** MÉTODO PARA MOSTRAR LA PÁGINA PRINCIPAL ******************

	// @GetMapping("/")
	// - Define que este método maneja **solicitudes GET** en la URL raíz `/`.
	// - Cuando un usuario acceda a `/`, se ejecutará `mostrarHome()`.
	@GetMapping("/")
	public String mostrarHome(Model modelo) { // Método que maneja la página principal

		// Llama al servicio `serviceVacantes` para obtener todas las vacantes disponibles.
		List<Vacante> lista = this.serviceVacantes.buscarTodasVacante();

		// Imprime en la consola las vacantes recuperadas (para depuración).
		System.out.println();
		System.out.println("(/) HomeController [buscarTodasVacante()] - home.html ==> List<Vacante> lista " + lista);
		System.out.println();

		// Agrega la lista de vacantes al modelo para que la vista pueda mostrarla.
		modelo.addAttribute("vacantes", lista);

		// Retorna el nombre de la vista que mostrará las vacantes en la página de inicio.
		return "home";
	}

	// ****************** MÉTODO PARA MOSTRAR DETALLE DE DOS VACANTES ******************

	// @GetMapping("/detalleAyB")
	// - Define que este método maneja **solicitudes GET** en la URL `/detalleAyB`.
	// - Se usará para mostrar detalles de dos vacantes específicas.
	@GetMapping("/detalleAyB")
	public String mostrarDetalleAyB(Model modelo) {
		// Se crean dos objetos `Vacante`
		Vacante vacanteA = new Vacante();
		Vacante vacanteB = new Vacante();

		// Configura la vacante A
		vacanteA.setNombre("Ing. de Comunicaciones");
		vacanteA.setDescripcion("Ing. para dar soporte a Intranet");
		vacanteA.setFecha(new Date()); // Asigna la fecha actual
		vacanteA.setSalario(9700000.0);
		modelo.addAttribute("vacanteA", vacanteA); // Agrega vacante A al modelo

		// Configura la vacante B
		vacanteB.setNombre("Ing. de Software");
		vacanteB.setDescripcion("Ing. para dar soporte a sistema Bancario");
		vacanteB.setFecha(new Date()); // Asigna la fecha actual
		vacanteB.setSalario(9999999.0);
		modelo.addAttribute("vacanteB", vacanteB); // Agrega vacante B al modelo

		// Retorna el nombre de la vista que mostrará los detalles de las vacantes.
		return "detalleAyB";
	}

	// ****************** MÉTODO PARA MOSTRAR LA VISTA DE DETALLE ******************

	@GetMapping("/detalle")
	public String mostrarDetalle(Model modelo) {
		// Llama al servicio `serviceVacantes` para obtener todas las vacantes disponibles.
		List<Vacante> lista = this.serviceVacantes.buscarTodasVacante();
		modelo.addAttribute("vacante", lista);

		// Retorna el nombre de la vista que mostrará el detalle de las vacantes.
		return "detalle";
	}

	// ****************** MÉTODO PARA MOSTRAR UNA LISTA DE EMPLEOS ******************

	@GetMapping("/listado")
	public String mostrarListado(Model modelo) {
		// Se crea una lista de empleos y se agregan algunos ejemplos.
		List<String> lista = new LinkedList<>();
		lista.add("Ingeniero de Software");
		lista.add("Auxiliar Contable");
		lista.add("Técnico en PCs");
		lista.add("Arquitecto");

		// Se agrega la lista al modelo para que la vista la muestre.
		modelo.addAttribute("empleos", lista);

		// Retorna la vista donde se mostrará la lista de empleos.
		return "listado";
	}

	// ****************** MÉTODO PARA MOSTRAR UNA TABLA DE VACANTES ******************

	@GetMapping("/tabla")
	public String mostrarTabla(Model modelo) {
		// Obtiene la lista de vacantes desde el servicio.
		List<Vacante> lista = this.serviceVacantes.buscarTodasVacante();

		// Agrega la lista de vacantes al modelo para que la vista pueda mostrarla en una tabla.
		modelo.addAttribute("vacantes", lista);

		// Retorna la vista que mostrará las vacantes en formato tabla.
		return "tabla";
	}

	/*
	 * 📌 Explicación detallada
	 * ✅ Este controlador maneja la lógica de presentación de vacantes en Spring Boot ✅ Spring Boot gestiona esta clase
	 * automáticamente gracias a @Controller ✅ Usa @Autowired para inyectar un servicio y obtener vacantes desde la capa de
	 * negocio ✅ Define múltiples métodos con @GetMapping para manejar distintas rutas HTTP
	 * 
	 * 🚀 Conclusión
	 * Este controlador administra la presentación de vacantes y listas de empleos en la aplicación.
	 */
	*/
}
