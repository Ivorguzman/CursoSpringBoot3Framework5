package com.ivor.empleos.model;


// Clase de tipo Java Beans
public class Categoria {

	private Integer id;
	private String nombre;
	private String descripcion;



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
		this.id= id;
	}

	public void setNombre(String nombre) {
		this.nombre= nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion= descripcion;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + this.id + ", nombre=" + this.nombre + ", descripcion=" + this.descripcion + "]";
	}


}
