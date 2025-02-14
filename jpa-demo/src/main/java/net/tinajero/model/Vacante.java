package net.tinajero.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/*
 * Indica que esta clase Vacante es una entidad de JPA.
 * Cada instancia de esta clase representa una fila en una tabla de la base de datos.
 */
@Entity
@Table(name = "vacantes")
public class Vacante {
	/*
	 * @GeneratedValue(strategy = GenerationType.IDENTITY): Especifica que el valor del id se generará automáticamente
	 * utilizando la estrategia de generación IDENTITY. Esto significa que la base de datos será responsable de generar
	 * valores únicos para el id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	// @DateTimeFormat(pattern= "yyyy-MM-dd") // Para procesos sencillos sin
	// validaciones extremas
	private Date fecha;
	private Double salario;
	private String estatus;
	private String imagen = "no-image.png";
	private Integer destacado;
	private String detalles;
	@Transient
	private Categoria categoria;


	public Vacante( ) {

	}


	// ************* Getters ************
	public String getStatus() {
		return this.estatus;
	}


	public String getDetalles() {
		return this.detalles;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}



	public Integer getDestacado() {
		return this.destacado;
	}


	public Date getFecha() {
		return this.fecha;
	}


	public Integer getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public Double getSalario() {
		return this.salario;
	}


	public String getImages() {
		return this.imagen;
	}





	// ************** Setters *************
	public void setStatus(String status) {
		this.estatus = status;
	}


	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public void setDestacado(Integer destacado) {
		this.destacado = destacado;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}



	public void setImages(String images) {
		System.out.println("Propiedad  images de la Clase Vacante =" + images);
		this.imagen = images;
	}


	@Override
	public String toString() {
		return "Vacante [nombre=" + this.nombre + ", descripcion=" + this.descripcion + ", id=" + this.id + ", fecha=" + this.fecha + ", salario=" + this.salario
				+ ", images=" + this.imagen + ", destacado=" + this.destacado + ", status=" + this.estatus + ", detalles=" + this.detalles + ", categoria=" + this.categoria
				+ "]";
	}







}
