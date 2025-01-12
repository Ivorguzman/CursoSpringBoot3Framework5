package com.ivor.empleos.model;

import java.util.Date;

public class Vacante {
	private String nombre;
	private String descripcion;
	private Integer id;
	// @DateTimeFormat(pattern= "yyyy-MM-dd") // Para procesos sencillos sin
	// validaciones extremas
	private Date fecha;
	private Double salario;
	private String images= "no-image.png";
	private Integer destacado;
	private String status;
	private String detalles;
	private String categoria;


	public Vacante( ) {

	}


	// Getters
	public String getStatus() {
		return this.status;
	}


	public String getDetalles() {
		return this.detalles;
	}

	public String getCategoria() {
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
		return this.images;
	}





	// Setters
	public void setStatus(String status) {
		this.status= status;
	}


	public void setDetalles(String detalles) {
		this.detalles= detalles;
	}


	public void setCategoria(String categoria) {
		this.categoria= categoria;
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
		this.images = images;
	}


	@Override
	public String toString() {
		return "Vacante [images=" + this.images + ", id=" + this.id + ", nombre=" + this.nombre + ", descripcion=" + this.descripcion + ", fecha=" + this.fecha + ", salario="
				+ this.salario + ", destacado=" + this.destacado + ", status=" + this.status + ", detalles=" + this.detalles + "]";
	}






}
