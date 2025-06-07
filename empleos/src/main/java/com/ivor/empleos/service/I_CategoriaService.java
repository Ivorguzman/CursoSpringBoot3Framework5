// ****************** PAQUETE ******************

// package com.ivor.empleos.service;
// - Define el paquete donde se encuentra esta interfaz dentro del proyecto.
// - Es una forma de organizar el código dentro de la aplicación.
package com.ivor.empleos.service;

// ****************** IMPORTACIÓN DE CLASES ******************

// import java.util.List;
// - Importa la interfaz `List`, que permite manejar listas de elementos.
// - Se usa para almacenar múltiples objetos `Categoria`.
import java.util.List;

// import com.ivor.empleos.model.Categoria;
// - Importa la clase `Categoria`, que representa una categoría de empleo.
// - Se usará en los métodos de la interfaz para gestionar categorías.
import com.ivor.empleos.model.Categoria;

// ****************** DEFINICIÓN DE LA INTERFAZ ******************

// public interface I_CategoriaService
// - Define una interfaz llamada `I_CategoriaService`.
// - En Spring, las interfaces son esenciales para la inyección de dependencias y la abstracción.
// - Los servicios que implementen esta interfaz deberán definir la lógica de negocio para gestionar categorías.
public interface I_CategoriaService {

	// ****************** MÉTODOS DE LA INTERFAZ ******************

	// void guardar(Categoria categoria);
	// - Define un método `guardar()`.
	// - `void` significa que no devuelve un valor.
	// - Recibe un objeto `Categoria`, lo cual indica que se usará para almacenar una nueva categoría.
	void guardar(Categoria categoria);

	// List<Categoria> buscarTodas();
	// - Define un método `buscarTodas()`, que devuelve una lista de todas las categorías.
	// - `List<Categoria>` indica que el método retorna una lista de objetos `Categoria`.
	// - Se usará en el servicio para recuperar todas las categorías disponibles.
	List<Categoria> buscarTodas();

	// Categoria buscarPorID(Integer idCategoria);
	// - Define un método `buscarPorID()` para buscar una categoría por su identificador (`idCategoria`).
	// - Retorna un objeto `Categoria` si se encuentra una coincidencia con el ID proporcionado.
	// - `Integer idCategoria` es el parámetro que representa el ID único de una categoría.
	Categoria buscarPorID(Integer idCategoria);
}


/*
 * 📌 Explicación detallada
 * ✅ Objetivo de la interfaz Esta interfaz define el contrato que los servicios de Spring deben implementar para
 * gestionar categorías de empleo.
 * 
 * ✅ ¿Por qué usamos interfaces en Spring Boot? 🔹 Abstracción → Separamos la declaración de los métodos de su
 * implementación. 🔹 Inyección de dependencias → Permite que Spring gestione los servicios sin necesidad de
 * instanciarlos manualmente. 🔹 Flexibilidad → Podemos cambiar la implementación sin afectar otras partes del código.
 * 
 * ✅ Métodos principales 🔸 guardar(Categoria categoria) → Permite almacenar una categoría en el sistema. 🔸
 * buscarTodas() → Recupera todas las categorías en forma de lista. 🔸 buscarPorID(Integer idCategoria) → Busca una
 * categoría específica por su ID.
 * 
 * 🚀 Conclusión
 * Esta interfaz es fundamental en una aplicación Spring Boot, ya que permite que el sistema gestione categorías de
 * empleo de manera estructurada
 */
