// ****************** PAQUETE Y DEPENDENCIAS ******************

// Definimos el paquete en el que se encuentra esta clase
package com.ivor.empleos.service;

// Importamos las clases necesarias para manejar fechas
import java.text.ParseException;  // Manejo de errores en conversión de fecha
import java.text.SimpleDateFormat; // Permite convertir cadenas en formato Date
import java.util.LinkedList; // Implementación de la interfaz List en una estructura enlazada
import java.util.List; // Interface para listas en Java

// Importamos la anotación @Service para indicar que esta clase es un servicio en Spring
import org.springframework.stereotype.Service;

// Importamos la clase Vacante que representa cada oferta de empleo
import com.ivor.empleos.model.Vacante;

// ****************** DEFINICIÓN DE LA CLASE ******************

// La anotación @Service indica que esta clase es un componente gestionado por Spring Es decir, le dice a Spring que
// esta clase debe ser gestionada como un Bean, lo que permite su uso en otras partes de la aplicación sin necesidad de
// instanciarla manualmente.
@Service
public class VacantesServiceImpl implements I_VacanteService {

	// ****************** ATRIBUTOS ******************


	// Declara una lista para almacenar objetos de tipo Vacante.
	// Inicialmente, la lista está vacía (null) y se debe inicializar antes de usarla.
	private List<Vacante> listaVacantes = null;


	// ****************** CONSTRUCTOR ******************

	/*
	 * Este constructor inicializa la lista de vacantes y agrega algunas vacantes de ejemplo.
	 */
	public VacantesServiceImpl( ) {

		// Crea un objeto SimpleDateFormat para manejar fechas en el formato "día-mes-año".
		// Este formato se utiliza para convertir cadenas de texto en objetos Date y viceversa.
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");




		// Inicializamos la lista listaVacantes como una LinkedList.
		// LinkedList es una implementación de la interfaz List que permite almacenar elementos de forma enlazada.
		this.listaVacantes = new LinkedList<Vacante>();


		try{
			// ****************** CREACIÓN DE VACANTES ******************

			// ---------- Vacante 1: Ingeniero Civil ----------
			Vacante vacante1 = new Vacante();  // Se crea un objeto vacante1
			vacante1.setId(1);  // Se asigna el identificador único 1
			vacante1.setNombre("Ingeniero Civil");  // Se establece el nombre del puesto
			vacante1.setDescripcion("Solicitamos Ing. Civil con experiencia en vialidades");  // Se define la descripción del trabajo
			vacante1.setFecha(sdf.parse("06-12-2024"));  // Se asigna la fecha de publicación (formato Date)
			vacante1.setSalario(3999.0);  // Se establece el salario en 3999.0 unidades monetarias
			vacante1.setDestacado(1);  // Se marca como vacante destacada (1 = Sí)
			vacante1.setImages("logo1.png");  // Se asigna una imagen representativa

			// ---------- Vacante 2: Contador Público ----------
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Público");
			vacante2.setDescripcion("Solicitamos Contador Fiscal con experiencia en IMPORTACIONES");
			vacante2.setFecha(sdf.parse("06-12-2024"));
			vacante2.setSalario(2999.0);
			vacante2.setDestacado(1);
			vacante2.setImages("logo2.png");

			// ---------- Vacante 3: Ingeniero Eléctrico ----------
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Eléctrico");
			vacante3.setDescripcion("Solicitamos Ing. Eléctrico con experiencia en Sistemas de ferrocarriles");
			vacante3.setFecha(sdf.parse("06-12-2024"));
			vacante3.setSalario(5999.0);
			vacante3.setDestacado(0); // Esta vacante no es destacada (0 = No)
			vacante3.setImages("logo3.png");

			// ---------- Vacante 4: Diseñador Gráfico ----------
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador Gráfico");
			vacante4.setDescripcion("Solicitamos Diseñador con experiencia en diseño editorial e Impresión OffSet");
			vacante4.setFecha(sdf.parse("06-12-2024"));
			vacante4.setSalario(3999.0);
			vacante4.setDestacado(1);
			vacante4.setImages("logo4.png");

			// ****************** AGREGAR VACANTES A LA LISTA ******************

			this.listaVacantes.add(vacante1);  // Se agrega vacante1 a la lista
			this.listaVacantes.add(vacante2);
			this.listaVacantes.add(vacante3);
			this.listaVacantes.add(vacante4);

			// Imprime el estado actual de la lista de vacantes en la consola.
			// Esto es útil para verificar qué objetos están almacenados en la lista en ese momento.
			// La salida mostrará una representación en cadena de los objetos contenidos en la lista.
			System.out.println("listaVacantes => : " + this.listaVacantes);



		} catch(ParseException ex){
			// En caso de error al convertir una fecha, imprimimos un mensaje en la consola
			System.out.println("ERROR => : " + ex.getMessage());
		}
	}

	// ****************** MÉTODOS DE SERVICIO ******************

	// Método para obtener todas las vacantes disponibles
	@Override
	public List<Vacante> buscarTodasVacante() {
		// Imprimimos el estado actual de la lista de vacantes en la consola
		System.out.println("VacanteServiceImp.java [buscarTodasVacante()]=> return this.listaVacantes " + this.listaVacantes);
		return this.listaVacantes;  // Retornamos la lista completa de vacantes
	}

	// Método para buscar una vacante específica por su ID
	@Override
	public Vacante buscarVarPorIdVacante(Integer idVacante) {
		// Recorremos toda la lista de vacantes
		for (Vacante _vacante : this.listaVacantes){
			System.out.println("v_Vacante = " + _vacante);  // Imprimimos cada vacante analizada
			if (_vacante.getId() == idVacante){  // Si el ID de la vacante coincide con el solicitado...
				return _vacante;  // Retornamos la vacante encontrada
			}
		}
		return null;  // Si no se encuentra ninguna vacante con ese ID, retornamos null
	}

	// Método para agregar una nueva vacante a la lista
	@Override
	public void guardar(Vacante vacante) {
		this.listaVacantes.add(vacante);  // Se agrega la nueva vacante a la lista
		System.out.println("lista_MetodoGuardar() = " + this.listaVacantes);  // Se imprime la lista actualizada
	}
}



/*
 * 📌 Concepto General
 * Este código en Java implementa un servicio para gestionar vacantes de empleo. Utiliza una lista (LinkedList<Vacante>)
 * para almacenar ofertas de trabajo, permitiendo consultar, buscar y agregar nuevas vacantes a la lista.
 * 
 * 🛠️ Cómo funciona
 * 1️⃣ Inicialización de la lista de vacantes
 * 
 * Se crea una lista de Vacante para almacenar ofertas de empleo.
 * 
 * Se usa SimpleDateFormat para manejar las fechas en formato "dd-MM-yyyy".
 * 
 * 2️⃣ Creación de vacantes
 * 
 * Se crean 4 vacantes con información como ID, nombre, descripción, fecha, salario, imagen y si son destacadas o no.
 * 
 * Cada vacante es agregada a la lista principal listaVacantes.
 * 
 * 3️⃣ Manejo de errores
 * 
 * Se utiliza try-catch para evitar fallos en la conversión de fechas (sdf.parse()).
 * 
 * Si ocurre un error, se muestra un mensaje en la consola.
 * 
 * 4️⃣ Métodos principales
 * 
 * buscarTodasVacante(): Devuelve todas las vacantes disponibles.
 * 
 * buscarVarPorIdVacante(Integer idVacante): Busca una vacante por su ID.
 * 
 * guardar(Vacante vacante): Agrega una nueva vacante a la lista.
 * 
 * 🔍 Detalles clave
 * ✅ Estructura organizada: Se utilizan objetos de la clase Vacante para manejar cada oferta. ✅ Búsqueda eficiente: Se
 * usa un ciclo for para recorrer la lista y encontrar vacantes por ID. ✅ Almacenamiento en memoria: Los datos se
 * guardan en una lista LinkedList, pero no en una base de datos. ✅ Simplicidad y escalabilidad: Se puede extender
 * fácilmente con funciones adicionales, como eliminar o actualizar vacantes.
 * 
 * 💡 Conclusión Este servicio es útil para administrar ofertas de empleo dentro de una aplicación. Su diseño permite
 * agregar nuevas vacantes, buscarlas por ID y obtener todas las disponibles. Si en el futuro quisieras conectarlo con
 * una base de datos o una interfaz gráfica, se podría adaptar fácilmente. 🚀
 * 
 * 
 * 
 */








