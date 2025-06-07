// ****************** PAQUETE ******************

// package com.ivor.empleos.service;
// - Define el paquete donde se encuentra esta interfaz dentro del proyecto.
// - Los paquetes ayudan a organizar el código y evitar conflictos entre clases con el mismo nombre.
package com.ivor.empleos.service;

// ****************** IMPORTACIÓN DE CLASES ******************

// import java.util.List;
// - Importa la interfaz `List`, que permite manejar listas de elementos.
// - Se usa para almacenar múltiples objetos `Vacante` en métodos de la interfaz.
import java.util.List;

// import com.ivor.empleos.model.Vacante;
// - Importa la clase `Vacante`, que representa una oferta de empleo.
// - Se usará en los métodos de la interfaz para gestionar vacantes.
import com.ivor.empleos.model.Vacante;

// ****************** DEFINICIÓN DE LA INTERFAZ ******************

// public interface I_VacanteService
// - Define una interfaz llamada `I_VacanteService`.
// - En Spring, las interfaces son esenciales para la inyección de dependencias y la abstracción.
// - Las clases que implementen esta interfaz deberán definir la lógica para gestionar vacantes.
public interface I_VacanteService {

	// ****************** MÉTODOS DE LA INTERFAZ ******************

	// List<Vacante> buscarTodasVacante();
	// - Define un método `buscarTodasVacante()` que devuelve una lista de todas las vacantes disponibles.
	// - `List<Vacante>` indica que el método retorna una lista de objetos `Vacante`.
	List<Vacante> buscarTodasVacante();

	// Vacante buscarVarPorIdVacante(Integer idVacante);
	// - Define un método `buscarVarPorIdVacante()` para buscar una vacante por su identificador (`idVacante`).
	// - Retorna un objeto `Vacante` si encuentra una coincidencia con el ID proporcionado.
	// - `Integer idVacante` es el parámetro que representa el ID único de una vacante.
	Vacante buscarVarPorIdVacante(Integer idVacante);

	// void guardar(Vacante vacante);
	// - Define un método `guardar()` para almacenar una nueva vacante en el sistema.
	// - `void` indica que el método no devuelve ningún valor.
	// - Recibe un objeto `Vacante`, lo cual indica que se usará para almacenar la vacante en una lista o base de datos.
	void guardar(Vacante vacante);

	/*
	 * 📌 Explicación detallada
	 * ✅ Objetivo de la interfaz Esta interfaz define el contrato que los servicios de Spring deben implementar para
	 * gestionar vacantes de empleo.
	 * 
	 * ✅ ¿Por qué usamos interfaces en Spring Boot? 🔹 Abstracción → Separamos la declaración de los métodos de su
	 * implementación. 🔹 Inyección de dependencias → Permite que Spring gestione los servicios sin necesidad de
	 * instanciarlos manualmente. 🔹 Flexibilidad → Podemos cambiar la implementación sin afectar otras partes del código.
	 * 
	 * ✅ Métodos principales 🔸 buscarTodasVacante() → Recupera todas las vacantes en forma de lista. 🔸
	 * buscarVarPorIdVacante(Integer idVacante) → Busca una vacante específica por su ID. 🔸 guardar(Vacante vacante) →
	 * Permite almacenar una vacante en el sistema.
	 * 
	 * 🚀 Conclusión
	 * Esta interfaz es fundamental en una aplicación Spring Boot, ya que permite que el sistema gestione vacantes de empleo
	 * de manera estructurada.
	 */
}




