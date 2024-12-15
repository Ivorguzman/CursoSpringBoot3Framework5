package com.ivor.empleos.model;

import java.util.Date;

public class Vacante {
	private Integer id;
	private String nombre;
	private String descripcion;
	private Date fecha;
	private Double salario;




	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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



	@Override
	public String toString() {
		return "Vacante [id=" + this.id + ", nombre=" + this.nombre + ", descripcion=" + this.descripcion + ", salario=" + this.salario + "]";
	}


}
