package net.tinajero.model; // Declaración del paquete donde se encuentra la clase

import java.util.Date; // Importa la clase Date para manejar fechas

import jakarta.persistence.Entity; // Importa la anotación @Entity para marcar la clase como entidad JPA
import jakarta.persistence.GeneratedValue; // Importa @GeneratedValue para generar IDs automáticamente
import jakarta.persistence.GenerationType; // Importa GenerationType para especificar la estrategia de generación de IDs
import jakarta.persistence.Id; // Importa @Id para indicar el campo clave primaria
import jakarta.persistence.JoinColumn; // Importa @JoinColumn para configurar la clave foránea en una relación
import jakarta.persistence.OneToOne; // Importa @OneToOne para definir relaciones uno a uno
import jakarta.persistence.Table; // Importa @Table para especificar la tabla asociada a la entidad

/*
 * Indica que esta clase Vacante es una entidad de JPA.
 * Cada instancia de esta clase representa una fila en una tabla de la base de datos.
 */
@Entity // Anotación que marca la clase como una entidad para JPA
@Table(name = "vacantes") // Especifica el nombre de la tabla en la base de datos
public class Vacante {
	/*
	 * @Id: Marca el campo 'id' como clave primaria.
	 *
	 * @GeneratedValue(strategy = GenerationType.IDENTITY):
	 * Especifica que el valor del id se generará automáticamente
	 * utilizando la estrategia IDENTITY, donde la base de datos es responsable de generar el valor.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // Campo 'id' de tipo Integer para identificar de manera única cada vacante

	private String nombre; // Campo 'nombre' para almacenar el título o nombre de la vacante
	private String descripcion; // Campo 'descripcion' para detallar información sobre la vacante

	// @DateTimeFormat(pattern= "yyyy-MM-dd")
	// Comentado: Para procesos sencillos sin validaciones extremas
	private Date fecha; // Campo 'fecha' de tipo Date para registrar la fecha de publicación

	private Double salario; // Campo 'salario' para indicar el salario ofrecido
	private String estatus; // Campo 'estatus' para indicar el estado de la vacante (e.g., abierta, cerrada)
	private String imagen = "no-image.png"; // Campo 'imagen' con valor por defecto 'no-image.png'
	private Integer destacado; // Campo 'destacado' para indicar si la vacante es destacada en listados
	private String detalles; // Campo 'detalles' para información adicional en formato HTML o texto extenso

	// @Transient
	@OneToOne // Indica una relación uno a uno con otra entidad
	@JoinColumn(name = "idCategoria") // Especifica la columna que hará la relación en la base de datos
	private Categoria categoria; // Campo 'categoria' que es una entidad relacionada

	// Constructor vacío necesario para JPA
	public Vacante( ) {
	}

	// ************* Getters ************

	public String getStatus() {
		return this.estatus; // Retorna el estatus de la vacante
	}

	public String getDetalles() {
		return this.detalles; // Retorna los detalles adicionales de la vacante
	}

	public Categoria getCategoria() {
		return this.categoria; // Retorna la categoría asociada a la vacante
	}

	public Integer getDestacado() {
		return this.destacado; // Indica si la vacante es destacada (e.g., 1 para sí, 0 para no)
	}

	public Date getFecha() {
		return this.fecha; // Retorna la fecha de publicación de la vacante
	}

	public Integer getId() {
		return this.id; // Retorna el ID único de la vacante
	}

	public String getNombre() {
		return this.nombre; // Retorna el nombre o título de la vacante
	}

	public String getDescripcion() {
		return this.descripcion; // Retorna la descripción de la vacante
	}

	public Double getSalario() {
		return this.salario; // Retorna el salario ofrecido para la vacante
	}

	public String getImages() {
		return this.imagen; // Retorna el nombre del archivo de imagen asociado a la vacante
	}

	// ************** Setters *************

	public void setStatus(String status) {
		this.estatus = status; // Asigna un valor al estatus de la vacante
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles; // Asigna detalles adicionales a la vacante
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria; // Asocia una categoría a la vacante
	}

	public void setDestacado(Integer destacado) {
		this.destacado = destacado; // Define si la vacante es destacada
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha; // Asigna una fecha de publicación a la vacante
	}

	public void setId(Integer id) {
		this.id = id; // Asigna un ID único a la vacante
	}

	public void setNombre(String nombre) {
		this.nombre = nombre; // Asigna un nombre o título a la vacante
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion; // Asigna una descripción detallada a la vacante
	}

	public void setSalario(Double salario) {
		this.salario = salario; // Asigna un salario ofrecido a la vacante
	}

	public void setImages(String images) {
		System.out.println("Propiedad images de la Clase Vacante = " + images); // Imprime en consola el nombre de la imagen asignada
		this.imagen = images; // Asigna el nombre del archivo de imagen a la vacante
	}

	@Override
	public String toString() {
		return "Vacante [nombre=" + this.nombre + ", descripcion=" + this.descripcion + ", id=" + this.id + ", fecha=" + this.fecha + ", salario=" + this.salario
				+ ", images=" + this.imagen + ", destacado=" + this.destacado + ", status=" + this.estatus + ", detalles=" + this.detalles + ", categoria=" + this.categoria
				+ "]";
		// Retorna una representación en cadena de la vacante, incluyendo todos sus atributos
	}
}
