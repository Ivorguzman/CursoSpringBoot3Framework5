package com.ivor.empleos.controllers;

import java.util.Date; // Importa la clase Date para manejar fechas
import java.util.LinkedList; // Importa la clase LinkedList para crear listas enlazadas
import java.util.List; // Importa la interfaz List para manejar listas

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Importa la anotación @Controller para marcar la clase como un controlador
import org.springframework.ui.Model; // Importa la interfaz Model para pasar datos a la vista
import org.springframework.web.bind.annotation.GetMapping; // Importa la anotación @GetMapping para manejar solicitudes GET

import com.ivor.empleos.model.Vacante; // Importa la clase Vacante desde el paquete com.ivor.empleos.model
import com.ivor.empleos.service.I_Vacanteservice;

@Controller // Marca esta clase como un controlador de Spring MVC indica que Spring debe inyectar automáticamente un bean de tipo I_Vacanteservice en este campo.
public class HomeController {


	// Sin Spring, esto sería equivalente a:
	@Autowired // this.serviceVacantes = new VacanteServiceImpl();
	private I_Vacanteservice serviceVacantes;

	// ****************************** (/) **************************
	@GetMapping("/") // Mapea las solicitudes HTTP GET en la URL raíz "/"
	public String mostrarHome(Model modelo) {
		// Datos para mostrar en la vista de inicio
		String nombre = "Auxiliar contable";
		Date fechaPublicacion = new Date(); // Fecha actual
		double salario = 9000.0;
		boolean vigente = true; // Estado de la vacante

		// Añade los datos al modelo para ser accedidos en la vista
		modelo.addAttribute("nombre", nombre);
		modelo.addAttribute("fechaPublicacion", fechaPublicacion);
		modelo.addAttribute("salario", salario);
		modelo.addAttribute("vigente", vigente);

		return "home"; // Retorna el nombre de la vista (home.html o home.jsp)
	}



	// ****************************** /detalle *******************************
	@GetMapping("/detalle") // Mapea las solicitudes HTTP GET en la URL "/detalle"
	public String mostrarDetalle(Model modelo) {
		Vacante vacanteA = new Vacante(); // Instancia de Vacante A
		Vacante vacanteB = new Vacante(); // Instancia de Vacante B

		// Configura vacante A
		vacanteA.setNombre("Ing. de Comunicaciones");
		vacanteA.setDescripcion("Ing. para dar soporte a Intranet");
		vacanteA.setFecha(new Date()); // Fecha actual
		vacanteA.setSalario(9700000.0);
		modelo.addAttribute("vacanteA", vacanteA); // Añade vacante A al modelo

		// Configura vacante B
		vacanteB.setNombre("Ing. de SoftWare");
		vacanteB.setDescripcion("Ing. para dar soporte a sistema Bancario");
		vacanteB.setFecha(new Date()); // Fecha actual
		vacanteB.setSalario(9999999.0);
		modelo.addAttribute("vacanteB", vacanteB); // Añade vacante B al modelo

		return "detalle"; // Retorna el nombre de la vista (detalle.html o detalle.jsp)
	}


	// ************************ /listado ******************************
	@GetMapping("/listado") // Mapea las solicitudes HTTP GET en la URL "/listado"
	public String mostrarListado(Model modelo) {
		// Lista de empleos
		List<String> lista = new LinkedList<>();
		lista.add("Ingeniero de SoftWare");
		lista.add("Auxiliar Contable");
		lista.add("Técnico en PCs");
		lista.add("Arquitecto");

		modelo.addAttribute("empleos", lista); // Añade la lista de empleos al modelo
		return "listado"; // Retorna el nombre de la vista (listado.html o listado.jsp)
	}



	// **************** /tabla *****************
	@GetMapping("/tabla") // Mapea las solicitudes HTTP GET en la URL "/tablaBootstrap"
	public String mostrarTabla(Model modelo) {
		List<Vacante> lista = this.serviceVacantes.buscarTodas(); // Obtiene la lista de vacantes
		System.out.println();
		System.out.println("lista_VariableLocal = " + lista); // Imprime la lista para depuración

		modelo.addAttribute("vacantes", lista); // Añade la lista de vacantes al modelo
		return "tabla"; // Retorna el nombre de la vista (tablaBootstrap.html)
	}
}
