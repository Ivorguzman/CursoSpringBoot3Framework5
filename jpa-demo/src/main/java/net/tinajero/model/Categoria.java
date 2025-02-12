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

	/*
	 * Lo que hace Spring detrás de Bambalinas:
	 * Mapeo ORM:(
	 * 
	 * En términos sencillos:
	 * Ubicar: Mapeo implica ubicar las clases y atributos de Java en las correspondientes tablas y columnas de la base de
	 * datos. Es decir, identificar dónde encaja cada cosa.
	 * 
	 * Poblar: Una vez ubicados, poblar significa llenar esas tablas y columnas con los datos de los objetos Java, y
	 * viceversa.
	 * 
	 * Así que, al mapear, efectivamente estás ubicando y poblando datos entre tu aplicación Java y tu base de datos.)
	 * 
	 * Entidad a Tabla: Cuando la aplicación se inicia, Spring Data JPA escanea las clases anotadas con @Entity y mapea la
	 * clase Categoria a la tabla "categorias" en la base de datos.
	 * 
	 * Campos a Columnas: Cada campo de la clase Categoria se mapea a una columna en la tabla "categorias".
	 * 
	 * Generación de SQL:
	 * Inserción: Cuando se guarda una nueva instancia de Categoria, Spring Data JPA genera una consulta INSERT para agregar
	 * una nueva fila a la tabla "categorias".
	 * 
	 * sql
	 * INSERT INTO categorias (nombre, descripcion) VALUES (?, ?);
	 * Actualización: Cuando se actualiza una instancia de Categoria, se genera una consulta UPDATE para modificar una fila
	 * existente en la tabla "categorias".
	 * 
	 * sql
	 * UPDATE categorias SET nombre = ?, descripcion = ? WHERE id = ?;
	 * Eliminación: Cuando se elimina una instancia de Categoria, se genera una consulta DELETE para eliminar una fila de la
	 * tabla "categorias".
	 * 
	 * sql
	 * DELETE FROM categorias WHERE id = ?;
	 * Consulta: Cuando se buscan instancias de Categoria, se generan consultas SELECT para recuperar datos de la tabla
	 * "categorias".
	 * 
	 * sql
	 * SELECT * FROM categorias;
	 * 
	 * Transacciones:
	 * Las operaciones de persistencia (guardar, actualizar, eliminar) se ejecutan dentro de transacciones para asegurar que
	 * los cambios en la base de datos sean consistentes.
	 * 
	 * Gestión del Ciclo de Vida:
	 * Spring Data JPA gestiona el ciclo de vida de las entidades, asegurando que se sincronizan correctamente con la base
	 * de datos cuando se realizan cambios.
	 */

}
