// ****************** PAQUETE ******************

// package com.ivor.empleos.model;
// - Define el paquete donde se encuentra esta clase dentro del proyecto.
// - Los paquetes ayudan a organizar el código en módulos, evitando conflictos entre clases con el mismo nombre.
package com.ivor.empleos.model;

// ****************** DEFINICIÓN DE LA CLASE ******************

// public class Categoria
// - Define una clase pública llamada `Categoria`.
// - Representa una categoría dentro de la aplicación (Ejemplo: "Tecnología", "Ventas", etc.).
public class Categoria {

	// ****************** ATRIBUTOS DE LA CLASE ******************

	// private Integer id;
	// - Declara una variable privada `id`, que almacenará el identificador único de cada categoría.
	private Integer id;

	// private String nombre;
	// - Declara una variable privada `nombre`, que guardará el nombre de la categoría.
	private String nombre;

	// private String descripcion = "En desarrollo";
	// - Declara una variable privada `descripcion`, que almacenará la descripción de la categoría.
	// - Se inicializa con el valor predeterminado `"En desarrollo"`, lo que significa que, si no se asigna otro valor, esta
	// será la descripción por defecto.
	private String descripcion = "En desarrollo";

	// ****************** CONSTRUCTOR ******************

	// public Categoria()
	// - Constructor vacío de la clase `Categoria`.
	// - Se usa para inicializar un objeto `Categoria` sin necesidad de asignarle valores iniciales.
	public Categoria( ) {
	}

	// ****************** MÉTODOS GETTERS ******************

	/*
	 * Métodos "getters" permiten obtener los valores de los atributos.
	 * Devuelven los valores almacenados en la instancia de la clase.
	 */

	// public Integer getId();
	// - Método que devuelve el valor almacenado en `id`.
	public Integer getId() {
		return this.id;
	}

	// public String getNombre();
	// - Método que devuelve el valor almacenado en `nombre`.
	public String getNombre() {
		return this.nombre;
	}

	// public String getDescripcion();
	// - Método que devuelve el valor almacenado en `descripcion`.
	public String getDescripcion() {
		return this.descripcion;
	}

	// ****************** MÉTODOS SETTERS ******************

	/*
	 * Métodos "setters" permiten asignar valores a los atributos.
	 * Se usan para modificar la información de una categoría existente.
	 */

	// public void setId(Integer id);
	// - Método que asigna un valor al atributo `id`.
	public void setId(Integer id) {
		this.id = id;
	}

	// public void setNombre(String nombre);
	// - Método que asigna un valor al atributo `nombre`.
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// public void setDescripcion(String descripcion);
	// - Método que asigna un valor al atributo `descripcion`.
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// ****************** MÉTODO toString ******************

	/*
	 * Este método sobrescribe `toString()` para devolver una representación en texto del objeto Categoria.
	 * Devuelve una cadena que muestra todos los atributos del objeto en formato legible.
	 */
	@Override
	public String toString() {
		return "Categoria [id=" + this.id + ", nombre=" + this.nombre + ", descripcion=" + this.descripcion + "]";
	}

	/*
	 * 📌 Explicación detallada
	 * ✅ ¿Qué hace esta clase? 🔹 Define una entidad llamada Categoria, que representa una categoría de empleo dentro de la
	 * aplicación. 🔹 Contiene atributos como id, nombre y descripcion, que guardan la información de cada categoría. 🔹 Usa
	 * métodos getters para obtener valores de los atributos y setters para asignarlos o modificarlos.
	 * 
	 * ✅ ¿Por qué se usa un constructor vacío? 🔹 Permite crear objetos Categoria sin necesidad de asignar valores
	 * iniciales. 🔹 Es útil cuando se trabaja con Spring y JPA, ya que el framework lo usa para instanciar entidades.
	 * 
	 * ✅ ¿Qué hace toString()? 🔹 Devuelve una representación legible del objeto Categoria, útil para imprimirlo en la
	 * consola.
	 * 
	 * 🚀 Conclusión
	 * Esta clase es una base esencial para manejar categorías en Spring Boot
	 */
}
