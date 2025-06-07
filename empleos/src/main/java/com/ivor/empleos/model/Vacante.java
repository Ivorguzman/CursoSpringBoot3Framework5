// ****************** PAQUETE ******************

// Declaramos el paquete donde se encuentra esta clase dentro del proyecto
package com.ivor.empleos.model;

// ****************** IMPORTACIÓN DE CLASES ******************

// Importamos la clase Date para manejar fechas
import java.util.Date;

// ****************** DEFINICIÓN DE LA CLASE ******************

// Definimos la clase `Vacante`, que representará una oferta de empleo
public class Vacante {

	// ****************** ATRIBUTOS ******************

	private String nombre; // Nombre del puesto de trabajo
	private String descripcion; // Breve descripción de la vacante
	private Integer id; // Identificador único de la vacante

	// @DateTimeFormat(pattern= "yyyy-MM-dd")
	// Esta anotación ayuda a definir el formato de fecha (yyyy-MM-dd)
	// Puede ser útil en procesos simples donde no se requieran validaciones complejas
	private Date fecha; // Fecha en la que se publicó la vacante

	private Double salario; // Salario ofrecido para el puesto
	private String images = "no-image.png"; // Ruta de la imagen de la vacante, valor por defecto "no-image.png"
	private Integer destacado; // Indica si la vacante es destacada (1 = Sí, 0 = No)
	private String status; // Estado de la vacante (Ejemplo: "Activa", "Cerrada", etc.)
	private String detalles; // Detalles adicionales de la vacante
	private Categoria categoria; // Categoría a la que pertenece la vacante (Ejemplo: "Tecnología", "Administración", etc.)

	// ****************** CONSTRUCTOR ******************

	/*
	 * Constructor vacío:
	 * - No recibe parámetros.
	 * - Se usa para inicializar objetos Vacante sin valores iniciales.
	 */
	public Vacante( ) {
	}

	// ****************** MÉTODOS GETTERS ******************

	/*
	 * Métodos "getters" permiten obtener los valores de los atributos.
	 * Devuelven los valores almacenados en la instancia de la clase.
	 */

	public String getStatus() { // Obtiene el estado de la vacante
		return this.status;
	}

	public String getDetalles() { // Obtiene los detalles adicionales
		return this.detalles;
	}

	public Categoria getCategoria() { // Obtiene la categoría de la vacante
		return this.categoria;
	}

	public Integer getDestacado() { // Obtiene si la vacante es destacada o no
		return this.destacado;
	}

	public Date getFecha() { // Obtiene la fecha de publicación de la vacante
		return this.fecha;
	}

	public Integer getId() { // Obtiene el identificador único de la vacante
		return this.id;
	}

	public String getNombre() { // Obtiene el nombre del puesto de trabajo
		return this.nombre;
	}

	public String getDescripcion() { // Obtiene la descripción de la vacante
		return this.descripcion;
	}

	public Double getSalario() { // Obtiene el salario ofrecido
		return this.salario;
	}

	public String getImages() { // Obtiene la imagen asociada a la vacante
		return this.images;
	}

	// ****************** MÉTODOS SETTERS ******************

	/*
	 * Métodos "setters" permiten asignar valores a los atributos.
	 * Se usan para modificar la información de una vacante existente.
	 */

	public void setStatus(String status) { // Asigna el estado de la vacante
		this.status = status;
	}

	public void setDetalles(String detalles) { // Asigna los detalles de la vacante
		this.detalles = detalles;
	}

	public void setCategoria(Categoria categoria) { // Asigna la categoría de la vacante
		this.categoria = categoria;
	}

	public void setDestacado(Integer destacado) { // Define si la vacante es destacada o no
		this.destacado = destacado;
	}

	public void setFecha(Date fecha) { // Asigna la fecha de publicación
		this.fecha = fecha;
	}

	public void setId(Integer id) { // Asigna el identificador único de la vacante
		this.id = id;
	}

	public void setNombre(String nombre) { // Asigna el nombre del puesto de trabajo
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) { // Asigna la descripción de la vacante
		this.descripcion = descripcion;
	}

	public void setSalario(Double salario) { // Asigna el salario ofrecido
		this.salario = salario;
	}

	/*
	 * Método setImages:
	 * - Asigna la imagen de la vacante.
	 * - Imprime la imagen asignada en consola para fines de depuración.
	 */
	public void setImages(String images) {
		System.out.println("Propiedad images de la Clase Vacante = " + images);
		this.images = images;
	}

	// ****************** MÉTODO toString ******************

	/*
	 * Este método sobrescribe `toString()` para devolver una representación en texto del objeto Vacante.
	 * Devuelve una cadena que muestra todos los atributos del objeto en formato legible.
	 */
	@Override
	public String toString() {
		return "Vacante [nombre=" + this.nombre + ", descripcion=" + this.descripcion + ", id=" + this.id + ", fecha=" + this.fecha + ", salario=" + this.salario
				+ ", images=" + this.images + ", destacado=" + this.destacado + ", status=" + this.status + ", detalles=" + this.detalles + ", categoria=" + this.categoria
				+ "]";
	}
}


/*
 * 📌 Explicación detallada
 * ✅ Objetivo: Representar una vacante de empleo dentro de la aplicación. ✅ Atributos principales: 🔹 nombre: Nombre del
 * puesto de trabajo. 🔹 descripcion: Breve descripción de la vacante. 🔹 id: Identificador único de cada vacante. 🔹
 * fecha: Fecha de publicación. 🔹 salario: Salario ofrecido. 🔹 images: Imagen de la vacante (por defecto
 * "no-image.png"). 🔹 destacado: Indica si la vacante es destacada (1 para sí, 0 para no). 🔹 status: Estado de la
 * vacante (Ejemplo: "Activa", "Cerrada", etc.). 🔹 detalles: Información adicional sobre la vacante. 🔹 categoria:
 * Categoría de trabajo (Ejemplo: "Tecnología", "Administración", etc.).
 * 
 * ✅ Métodos 🔸 Getters permiten obtener información de los atributos. 🔸 Setters permiten modificar valores de los
 * atributos. 🔸 toString() devuelve una representación textual del objeto para mostrar en consola.
 * 
 * 🚀 Conclusión
 * Este código es una excelente representación de una entidad Vacante dentro de una aplicación. Puede expandirse para
 * agregar funcionalidades como validaciones, persistencia en base de datos o incluso la integración con un sistema de
 * gestión de empleos.
 */
