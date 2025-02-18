package net.tinajero.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Anotación que marca la clase como una entidad para JPA
@Table(name = "perfiles") // Especifica el nombre de la tabla en la base de datos
public class Perfiles {

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
	String perfil;



	// ************* Getters ************
	public int getId() {
		return this.id;
	}

	public String getPerfil() {
		return this.perfil;
	}



	// ************** Setters *************
	public void setId(int id) {
		this.id = id;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}
