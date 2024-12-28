package com.ivor.empleos.model;

import java.util.Date;

public class Vacante {
	private Integer id;
	private String nombre;
	private String descripcion;
	private Date fecha;
	private Double salario;
	private Integer destacado;
	private String images = "no-image.png";

	public Vacante( ) {

	}




	// Getters
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
		return this.images;
	}





	// Setters
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
		this.images = images;
	}



	@Override
	public String toString() {
		return "Vacante [id=" + this.id + ", nombre=" + this.nombre + ", descripcion=" + this.descripcion + ", salario=" + this.salario + "]";
	}



}
