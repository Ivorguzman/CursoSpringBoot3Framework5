package net.tinajero.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity // Anotación que marca la clase como una entidad para JPA
@Table(name = "usuarios") // Especifica el nombre de la tabla en la base de datos
public class Usuarios {


	/*
	 * @Id: Marca el campo 'id' como clave primaria.
	 *
	 * @GeneratedValue(strategy = GenerationType.IDENTITY):
	 * Especifica que el valor del id se generará automáticamente
	 * utilizando la estrategia IDENTITY, donde la base de datos es responsable de generar el valor.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nombre;
	String email;
	String userName;
	String passWord;
	int estatus;
	Date fechaDeRegistro;



	// ************* Getters ************
	public String getNombre() {
		return this.nombre;
	}

	public String getEmail() {
		return this.email;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public int getEstatus() {
		return this.estatus;
	}

	public Date getFechaDeRegistro() {
		return this.fechaDeRegistro;
	}



	// ************** Setters *************

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public void setFechaDeRegistro(Date fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}



}
