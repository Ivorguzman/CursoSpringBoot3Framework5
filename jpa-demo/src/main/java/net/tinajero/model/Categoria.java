package net.tinajero.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
/*
 * Indica que esta clase Categoria es una entidad de JPA.
 * Cada instancia de esta clase representa una fila en una tabla de la base de datos.
 */
public class Categoria {




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



	public Categoria( ) {

	}




	// ***** Getters *****
	public Integer getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}


	// **** Setters *****
	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + this.id + ", nombre=" + this.nombre + ", descripcion=" + this.descripcion + "]";
	}


}
