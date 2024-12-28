package com.ivor.empleos.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ivor.empleos.model.Vacante;

@Controller
public class HomeController {



	// ****************************** (/) **************************
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






	// ****************************** /detalle *******************************
	@GetMapping("/detalle")
	public String mostrarDetalle(Model modelo) {

		Vacante vacanteA = new Vacante();
		Vacante vacanteB = new Vacante();


		// *********** Instancia(Objeto) vacanteA
		vacanteA.setNombre("Ing. de  Comunicaciones");
		vacanteA.setDescripcion("Ing. para dar soporte a Intranet");
		vacanteA.setFecha(new Date());
		vacanteA.setSalario(9700000.0);
		modelo.addAttribute("vacanteA", vacanteA);


		// *********** Instancia(Objeto) vacanteB
		vacanteB.setNombre("Ing. de SoftWare");
		vacanteB.setDescripcion("Ing. para dar soporte a sistema Bancario");
		vacanteB.setFecha(new Date());
		vacanteB.setSalario(9999999.0);
		modelo.addAttribute("vacanteB", vacanteB);

		return "detalle";
	}








	// ************************ /listado ******************************
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





	// ********************************** /tablaBootstrap (Metodo getVacante()) ************************
	@GetMapping("/tablaBootstrap")
	public String mostrarTabla(Model modelo) {

		List<Vacante> lista = this.getVacante();
		System.out.println("lista = " + lista);

		modelo.addAttribute("vacantes", lista);


		// return "tabla";
		return "tablaBootstrap";

	}




	private List<Vacante> getVacante() {


		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");

		List<Vacante> lista = new LinkedList<>();


		try{
			// Crear oferta de trabajo 1
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Solicitamos Ing. Civil  con experiencia en vialidades");
			vacante1.setFecha(sdf.parse("06-12-2024"));
			vacante1.setSalario(3999.0);
			vacante1.setDestacado(1);
			vacante1.setImages("empresa1.png");
			lista.add(vacante1);



			// Crear oferta de trabajo 2
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Publico");
			vacante2.setDescripcion("Solicitamos Contador Fiscal  con experiencia  en IMPORTACIONES");
			vacante2.setFecha(sdf.parse("06-12-2024"));
			vacante2.setSalario(2999.0);
			vacante2.setDestacado(1);
			vacante2.setImages("empresa2.png");
			lista.add(vacante2);



			// Crear oferta de trabajo 3
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Electrico");
			vacante3.setDescripcion("Solicitamos Ing. Electrico  con experiencia Sistemas de ferrocarriles");
			vacante3.setFecha(sdf.parse("06-12-2024"));
			vacante3.setSalario(5999.0);
			vacante3.setDestacado(0);
			// vacante3.setImages(null);
			// vacante3.setImages("empresa3.png");
			lista.add(vacante3);



			// Crear oferta de trabajo 4
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador Gráfico");
			vacante4.setDescripcion("Solicitamos Diseñador con experiencia diseño editorial e Ipresión OffSet");
			vacante4.setFecha(sdf.parse("06-12-2024"));
			vacante4.setSalario(3999.0);
			vacante4.setDestacado(1);
			vacante4.setImages("empresa4.png");
			lista.add(vacante4);

		} catch(ParseException ex){

			System.out.println("ERROR => : " + ex.getMessage());
		}
		return lista;
	}
}

































