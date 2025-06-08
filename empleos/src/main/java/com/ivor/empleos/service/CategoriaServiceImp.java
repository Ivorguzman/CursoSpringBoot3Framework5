// ****************** PAQUETE ******************

// package com.ivor.empleos.service;
// - Define el paquete donde se encuentra esta clase dentro del proyecto.
// - Los paquetes ayudan a organizar el código y evitar conflictos entre clases con el mismo nombre.
package com.ivor.empleos.service;

// ****************** IMPORTACIÓN DE CLASES ******************

// import java.util.LinkedList;
// - Importa `LinkedList`, una implementación de la interfaz `List` en Java.
// - Se usa para almacenar objetos `Categoria` en una lista enlazada.
import java.util.LinkedList;
// import java.util.List;
// - Importa la interfaz `List`, que define una estructura de lista en Java.
// - `LinkedList` implementa `List`, lo que permite su uso en el código.
import java.util.List;

// import org.springframework.stereotype.Service;
// - Importa la anotación `@Service`, que marca esta clase como un servicio en Spring Boot.
// - Los servicios en Spring manejan la lógica de negocio y son gestionados automáticamente.
import org.springframework.stereotype.Service;

// import com.ivor.empleos.model.Categoria;
// - Importa la clase `Categoria`, que representa una categoría de empleo.
// - Se usará en los métodos de este servicio para manejar categorías.
import com.ivor.empleos.model.Categoria;

// ****************** DEFINICIÓN DE LA CLASE ******************

// @Service
// - Declara que esta clase es un **servicio de Spring Boot**.
// - Permite que Spring administre automáticamente su ciclo de vida e inyección de dependencias.
@Service
public class CategoriaServiceImp implements I_CategoriaService {

	// ****************** ATRIBUTOS ******************

	// private List<Categoria> listaCategorias = null;
	// - Se declara una lista de categorías (`listaCategorias`), inicialmente vacía.
	// - Se usará para almacenar las categorías en memoria.
	private List<Categoria> listaCategorias = null;

	/*
	 * List<Categoria>:
	 * - `LinkedList` es una clase concreta que implementa la interfaz `List`.
	 * - Gracias a **polimorfismo**, una variable de tipo `List` puede referirse a objetos `LinkedList`.
	 * 
	 * new LinkedList<>():
	 * - Crea una nueva instancia de `LinkedList<Categoria>`.
	 * - Se asigna a `listaCategorias`, que actuará como una lista dinámica de categorías.
	 */

	// ****************** CONSTRUCTOR ******************

	// public CategoriaServiceImp() { ... }
	// - Constructor de la clase `CategoriaServiceImp`.
	// - Se ejecuta automáticamente cuando se crea un objeto de esta clase.
	public CategoriaServiceImp( ) {

		// Inicialización de `listaCategorias` como una lista enlazada vacía (`LinkedList`).
		this.listaCategorias = new LinkedList<Categoria>();

		// ****************** CREACIÓN DE CATEGORÍAS ******************

		// ---------- Categoría 1: Ventas ----------
		Categoria categoria1 = new Categoria();
		categoria1.setId(1); // ID de la categoría
		categoria1.setNombre("Ventas"); // Nombre de la categoría
		categoria1.setDescripcion(null); // No se establece una descripción

		// ---------- Categoría 2: Contabilidad ----------
		Categoria categoria2 = new Categoria();
		categoria2.setId(2);
		categoria2.setNombre("Contabilidad");
		categoria2.setDescripcion(null);

		// ---------- Categoría 3: Transporte ----------
		Categoria categoria3 = new Categoria();
		categoria3.setId(3);
		categoria3.setNombre("Transporte");
		categoria3.setDescripcion(null);

		// ---------- Categoría 4: Informática ----------
		Categoria categoria4 = new Categoria();
		categoria4.setId(4);
		categoria4.setNombre("Informática");
		categoria4.setDescripcion(null);

		// ---------- Categoría 5: Construcción ----------
		Categoria categoria5 = new Categoria();
		categoria5.setId(5);
		categoria5.setNombre("Construcción");
		categoria5.setDescripcion(null);

		// ---------- Categoría 6: Desarrollo Java ----------
		Categoria categoria6 = new Categoria();
		categoria6.setId(6);
		categoria6.setNombre("Desarrollo Java (Java Spring)");
		categoria6.setDescripcion(null);

		// ****************** AGREGAR CATEGORÍAS A LA LISTA ******************

		// Se agregan todas las categorías a la lista de memoria.
		this.listaCategorias.add(categoria1);
		this.listaCategorias.add(categoria2);
		this.listaCategorias.add(categoria3);
		this.listaCategorias.add(categoria4);
		this.listaCategorias.add(categoria5);
		this.listaCategorias.add(categoria6);
	}

	// ****************** MÉTODOS DEL SERVICIO ******************

	// @Override
	// - Indica que este método sobrescribe la implementación de la interfaz `I_CategoriaService`.
	@Override
	public void guardar(Categoria categoria) {
		// Agrega la nueva categoría a `listaCategorias`.
		this.listaCategorias.add(categoria);

		// Imprime la lista de categorías después de la inserción (para depuración).
		System.out.println("categoria_MetodoGuardar() = " + this.listaCategorias);
		System.out.println();
	}

	// Método para obtener todas las categorías almacenadas.
	@Override
	public List<Categoria> buscarTodas() {
		// Imprime el estado actual de `listaCategorias` en la consola.
		System.out.println();
		System.out.println("CategoriaServiceImp.java <<buscarTodas()>> : " + this.listaCategorias);
		System.out.println();

		// Retorna la lista completa de categorías.
		return this.listaCategorias;
	}

	// Método para buscar una categoría específica por su ID.
	@Override
	public Categoria buscarPorID(Integer idCategoria) {
		// Se recorre la lista de categorías.
		for (Categoria _categoria : this.listaCategorias){

			// Si el ID de la categoría coincide con `idCategoria`, retorna la categoría encontrada.
			if (_categoria.getId() == idCategoria){
				return _categoria;
			}
		}

		// Si no se encuentra una coincidencia, se retorna `null`.
		return null;
	}
}
