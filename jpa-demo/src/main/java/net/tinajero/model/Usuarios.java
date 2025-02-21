package net.tinajero.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	private int id;
	private String nombre;
	private String email;
	private String userName;
	private String passWord;
	private int estatus;
	private Date fechaDeRegistro;


	/*
	 * @ManyToMany es una anotación en Java utilizada para especificar una relación de muchos a muchos entre dos entidades.
	 * Significa que una entidad puede estar relacionada con múltiples instancias de otra entidad, y viceversa.
	 * 
	 * fetch = FetchType.EAGER es un parámetro que se utiliza con la anotación @ManyToMany para definir cómo se deben cargar
	 * las entidades relacionadas.
	 * 
	 * FetchType.EAGER significa que todas las entidades relacionadas se cargarán de inmediato junto con la entidad
	 * principal, en lugar de cargarse solo cuando sean necesarias. Esto puede ser útil si sabes que siempre necesitarás
	 * esos datos relacionados.
	 * 
	 * Nota importante: Este tipo de carga puede consumir más memoria y recursos, porque todas las entidades relacionadas se
	 * cargan al mismo tiempo.
	 */
	@ManyToMany(fetch = FetchType.EAGER)


	/*
	 * @JoinTable: Esta anotación se usa para definir la tabla intermedia en una relación de muchos a muchos. Incluye dos
	 * atributos principales:
	 * 
	 * name = "usuarioperfil" especifica el nombre de la tabla intermedia que se creará en la base de datos. En este caso,
	 * la tabla se llamará "usuarioperfil".
	 * 
	 *
	 * joinColumns = @JoinColumn(name = "idUsuario")
	 * 
	 * joinColumns -> Este el parámetro que especifica las columnas que se usarán para unirse a la tabla principal (en este
	 * caso, la tabla que representa a los usuarios).Puedes ponerle el nombre que desees, siempre y cuando siga ciertas
	 * reglas y sea consistente con el esquema de tu base de datos.
	 * 
	 * 
	 * 
	 * @JoinColumn(name = "idUsuario") Esta Anotacionn define el nombre de la columna en la tabla intermedia que se usará
	 * para almacenar los identificadores de los usuarios. Name dentro de la anotación @JoinColumn es un parámetro, y puedes
	 * ponerle el nombre que desees. Este parámetro especifica el nombre de la columna en la tabla que se usará para la
	 * unión
	 *
	 */
	@JoinTable(name = "usuarioperfil", joinColumns = @JoinColumn(name = "idUsuario"))
	private List<Perfil> perfiles;




	// ************* Getters ************
	public List<Perfil> getPerfiles() {
		return this.perfiles;
	}

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
	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

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
