// Define el paquete al que pertenece esta clase.
package net.tinajero; // Organización del código en un paquete llamado "net.tinajero".

// Importaciones de clases necesarias de Java.
import java.util.Date; // Clase para manejar fechas.
import java.util.LinkedList; // Implementación de la interfaz List con una estructura de lista enlazada.
import java.util.List; // Interfaz que define listas de elementos.
import java.util.Optional; // Clase contenedora que puede representar un valor presente o ausente.

// Importaciones de Spring Boot.
import org.springframework.beans.factory.annotation.Autowired; // Anotación para la inyección automática de dependencias.
import org.springframework.boot.CommandLineRunner; // Interfaz que permite ejecutar código al iniciar la aplicación.
import org.springframework.boot.SpringApplication; // Clase principal para iniciar una aplicación Spring Boot.
import org.springframework.boot.autoconfigure.SpringBootApplication; // Indica que esta es una aplicación Spring Boot con configuración automática.
// Importaciones relacionadas con la paginación y ordenamiento de datos en consultas.
import org.springframework.data.domain.Page; // Representa una página de datos obtenidos de la base de datos.
import org.springframework.data.domain.PageRequest; // Permite solicitar páginas con un tamaño específico.
import org.springframework.data.domain.Sort; // Define criterios de ordenamiento de datos.

// Importaciones de los modelos que representan entidades de la base de datos.
import net.tinajero.model.Categoria; // Clase que representa una categoría.
import net.tinajero.model.Perfil; // Clase que representa un perfil.
import net.tinajero.model.Usuarios; // Clase que representa un usuario.
import net.tinajero.model.Vacante; // Clase que representa una vacante.
// Importaciones de los repositorios que gestionan la persistencia de datos.
import net.tinajero.repository.IR_CategoriaRepository; // Repositorio para la entidad Categoria.
import net.tinajero.repository.IR_PerfilesRepository; // Repositorio para la entidad Perfil.
import net.tinajero.repository.IR_UsuariosRepository; // Repositorio para la entidad Usuarios.
import net.tinajero.repository.IR_VacanteRepository; // Repositorio para la entidad Vacante.

// Anotación que marca esta clase como una aplicación Spring Boot con configuración automática.
@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner { // Implementa CommandLineRunner para ejecutar código al inicio.

	// Inyección automática de dependencias: Spring Boot inicializa estas instancias de repositorios.
	// Importamos la anotación @Autowired, que permite la inyección automática de dependencias en Spring Boot.
	import org.springframework.beans.factory.annotation.Autowired;

	// La anotación @Autowired permite que Spring Boot inicialice automáticamente las instancias de los repositorios.
	// En lugar de crear manualmente los objetos con 'new', Spring Boot se encarga de proporcionar las instancias correctas.

	// 🔹 Inyección de dependencia para el repositorio que gestiona las categorías.
	@Autowired // Spring busca un bean que coincida con esta interfaz y lo asigna automáticamente a la variable.
	private IR_CategoriaRepository repositorioCategoria; // Instancia del repositorio para gestionar datos de 'Categoria' en la base de datos.

	// 🔹 Inyección de dependencia para el repositorio que gestiona las vacantes.
	@Autowired // Spring inyecta una instancia del repositorio de vacantes, permitiendo acceder y modificar los datos de la entidad 'Vacante'.
	private IR_VacanteRepository repositorioVacante; // Se usa para realizar operaciones CRUD (Create, Read, Update, Delete) sobre 'Vacante'.

	// 🔹 Inyección de dependencia para el repositorio que gestiona los perfiles.
	@Autowired // Con esta anotación, Spring Boot asigna automáticamente el repositorio adecuado para gestionar 'Perfil'.
	private IR_PerfilesRepository repositorioPerfiles; // Permite acceder a los registros de perfiles almacenados en la base de datos.

	// 🔹 Inyección de dependencia para el repositorio que gestiona los usuarios.
	@Autowired // Indica a Spring Boot que debe inyectar una instancia válida del repositorio de usuarios.
	private IR_UsuariosRepository repositorioUsuarios; // Se usa para consultar y modificar datos de usuarios.
	/*
	 * 📌 ¿Cómo funciona la inyección de dependencias con @Autowired?
1️⃣ Spring Boot analiza las clases al arrancar la aplicación
2️⃣ Detecta las anotaciones @Autowired y busca un Bean (objeto) adecuado en el contexto
3️⃣ Si encuentra un Bean que coincide con la interfaz del repositorio, lo asigna automáticamente a la variable
4️⃣ Después de la inyección, puedes usar los repositorios sin necesidad de inicializarlos manualmente

📌 ¿Por qué se usa este enfoque?
🔹 Reduce la cantidad de código repetitivo, ya que no tienes que instanciar objetos manualmente
🔹 Asegura una mejor gestión de dependencias, dejando que Spring controle el ciclo de vida de los objetos
🔹 Hace que el código sea más modular y reutilizable, permitiendo cambiar la implementación del repositorio sin afectar otras partes del código
🔹 Facilita la escritura de pruebas, ya que puedes reemplazar los repositorios con versiones simuladas fácilmente
 */
	
	
	
	

	// Método principal que inicia la aplicación Spring Boot.
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args); // Ejecuta la aplicación Spring Boot.
	}

	// Método que se ejecuta automáticamente después de que Spring Boot ha inicializado la aplicación.
	@Override
	public void run(String... args) throws Exception {
		// Aquí se pueden escribir acciones que se ejecuten al iniciar la aplicación,
		// como insertar datos en la base de datos o realizar consultas iniciales.
		System.out.println("========================== > Ejecutando public void run(...){......} < =========================");
		// ****** Metodo utilizados extendiendo de la intrfaz CrudRepositoryen el modelo Categoria********
		// this.guardar();
		// this.eliminarTodos();
		// this.guardarTodasInstacias();
		// this.buscarPorId();
		// this.obtenerListaCategoria();
		// this.modificar();
		// this.eliminar();
		// this.contar();
		// this.econtrarEstosIds();
		// this.buscarTodoRegistos();
		// this.existeId();


		// ****** Metodo utilizados extendiendo de la intrfaz JpaRepository modelo Categoria ********
		// this.buscarTodosJpa();
		// this.borrarTodoRegistrosBloqueJpa();
		// this.buscarTodoOrdenadoJpa();
		// this.buscarTodoSoloPaginacion();
		// this.buscarTodosPaginacionOrdenamineto();
		// this.buscarTodosJpa();


		// **************************************************** //

		// ****** Metodo utilizados extendiendo de la intrfaz JpaRepository modelo Vacante ********

		// this.crearVacante();
		// this.buscarVacantes();
		// this.guardarVacante();
		// this.crearPerfilesAplicacion();
		// this.crearUsuarioConUnPerfil();

	}








	private void guardar() {

		System.out.println("########################### .save(?) guardar() Registro ##############################");
		Categoria catagoria = new Categoria();
		catagoria.setNombre("Finanzas");
		catagoria.setDescripcion("Trabajo de finanzas y contabilidad");
		this.repositorioCategoria.save(catagoria);
		System.out.println("I_CategoriaRepository repositorio ==>" + this.repositorioCategoria);
		System.out.println("catagoria ==> " + catagoria);
	}


	/*
	 * private void modificar() {
	 * System.out.println("########################### modificar() Registro ##############################");
	 * Optional<Categoria> optional = this.repositorio.findById(2);
	 * if (!optional.isEmpty()){
	 * Categoria categoriaTemporal = optional.get();
	 * System.out.println("Categoria categoriaTemporal = optional.get() ==> " + categoriaTemporal);
	 * } else{
	 * System.out.println("optional.isEmpty() Id no exixte ==> " + optional.isEmpty());
	 * }
	 * 
	 * }
	 */


	// Definición del método 'modificar'. Es privado y no devuelve ningún valor (void).
	private void modificar() {

		// Imprime un mensaje en la consola para indicar el inicio del método.
		System.out.println("###########################.save(...)  modificar() Registro ##############################");

		/*
		 * Busca una categoría en el repositorio por su ID (en este caso, ID = 2).
		 * - 'this.repositorio.findById(2)': Llama al método 'findById' del repositorio para buscar la categoría con ID 2.
		 * - 'Optional<Categoria>': El resultado se almacena en un objeto 'Optional', que puede contener la categoría o estar
		 * vacío.
		 */
		Optional<Categoria> optional = this.repositorioCategoria.findById(2);

		/*
		 * Si el 'Optional' contiene un valor (es decir, la categoría existe), se ejecuta este bloque.
		 * - 'ifPresent': Método de 'Optional' que recibe una expresión lambda.
		 * - 'categoriaTemporal':categoriaTemporal es el nombre del parámetro que recibe la expresión lambda. En este caso, si
		 * el Optional contiene un valor, ese valor será asignado a categoriaTemporal.
		 */
		optional.ifPresent((categoriaTemporal)-> {
			// Imprime en la consola la categoría encontrada.

			// Actualiza el nombre y la descripción de la categoría.
			categoriaTemporal.setNombre("Desarrollador Java Spring Boot");
			categoriaTemporal.setDescripcion("Desarrollo de End-Points y su mantenimiento");
			System.out.println("Categoria categoriaTemporal = optional.ifPresent() ==> " + categoriaTemporal);

			// Guarda la categoría actualizada en el repositorio.
			this.repositorioCategoria.save(categoriaTemporal);
		});


		/*
		 * Si el 'Optional' está vacío (es decir, no se encontró ninguna categoría con el ID especificado), se ejecuta este
		 * bloque.
		 * - 'isEmpty': Método de 'Optional' que devuelve 'true' si no contiene ningún valor.
		 */
		if (optional.isEmpty()){
			// Imprime en la consola un mensaje indicando que no se encontró la categoría.
			System.out.println("optional.isEmpty() Id no existe ==> " + optional.isEmpty());
		}
	}

	private void buscarPorId() {
		// Imprime un mensaje en la consola para indicar que se está ejecutando el método buscarPorId.
		System.out.println("########################### .findById(...) buscarPorId()  Registro ##############################");

		// Busca una entidad de tipo Categoria en el repositorio por su ID (en este caso, el ID es 2).
		// El método findById devuelve un Optional, que puede contener la entidad si existe, o estar vacío si no.
		Optional<Categoria> optional = this.repositorioCategoria.findById(2);

		// Imprime el repositorio en la consola. Esto puede ser útil para depuración, pero no es común en producción.
		System.out.println(" Optional<Categoria> repositorio.findById(...) ==>  " + this.repositorioCategoria);

		// Verifica si el Optional contiene una entidad (es decir, si se encontró la categoría con el ID 2).
		if (optional.isPresent()){
			// Si la entidad existe, la obtiene del Optional y la imprime en la consola.
			System.out.println("optional.get() ==> " + optional.get());
		} else{
			// Si no se encuentra la entidad, imprime un mensaje indicando que no se encontró.
			System.out.println("La Clase Categoria no se encontró");
		}
	}

	private void eliminar() {
		// Imprime un mensaje en la consola para indicar que se está ejecutando el método eliminar.
		System.out.println("########################### deleteById(...) eliminar() Registro ##############################");

		// Define el ID de la entidad que se desea eliminar (en este caso, el ID es 18).
		int id = 18;

		// Elimina la entidad con el ID especificado del repositorio repositorioCategoria.
		// this.repositorioCategoria.deleteById(id);


		// Elimina la entidad con el ID especificado del repositorio repositorioVacante.
		// this.repositorioVacante.deleteById(id);


		// Elimina la entidad con el ID especificado del repositorio repositorioPerfiles.
		// this.repositorioPerfiles.deleteById(id);


		// Imprime el repositorio en la consola. Esto puede ser útil para depuración, pero no es común en producción.
		// System.out.println("deleteById(id) ==> Categoria " + this.repositorioCategoria);

		// Imprime el repositorio en la consola. Esto puede ser útil para depuración, pero no es común en producción.
		// System.out.println("deleteById(id) ==> Vacante " + this.repositorioVacante);

		// Imprime el repositorio en la consola. Esto puede ser útil para depuración, pero no es común en producción.
		System.out.println("deleteById(id) Perfiles. ==>  " + this.repositorioPerfiles);
	}

	private void contar() {
		// Imprime un mensaje en la consola para indicar que se está ejecutando el método contar.
		System.out.println("##### .count() Registro devuelve la cantidad de entidades (registros) del tipo categorias (tablas) almacenadas en la BD #####");

		// Cuenta el número total de entidades de tipo Categoria almacenadas en la base de datos.
		long conteo = this.repositorioCategoria.count();

		// Imprime el número total de entidades en la consola.
		System.out.println("this.repositorio.count() ==> " + conteo);
	}

	private void eliminarTodos() {
		// Imprime un mensaje en la consola para indicar que se está ejecutando el método eliminarTodos.
		System.out.println("########################### .deleteAll() eliminarTodos() Registro ##############################");

		// Elimina todas las entidades de tipo Categoria del repositorio.
		this.repositorioCategoria.deleteAll();
	}

	private void econtrarEstosIds() {
		// Imprime un mensaje en la consola para indicar que se está ejecutando el método econtrarEstosIds.
		System.out.println("########################### .findAllById(...) econtrarEstosIds() en Registro ##############################");

		// Crea una lista de IDs que se desean buscar en el repositorio.
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(14);
		ids.add(12);
		ids.add(13);

		// Busca todas las entidades de tipo Categoria cuyos IDs estén en la lista proporcionada.
		Iterable<Categoria> categoria = this.repositorioCategoria.findAllById(ids);

		// Itera sobre las entidades encontradas y las imprime en la consola.
		for (Categoria temporalCategoria : categoria){
			System.out.println("temporalCategoria ==> " + temporalCategoria);
		}
	}

	private void buscarTodoRegistos() {
		// Imprime un mensaje en la consola para indicar que se está ejecutando el método buscarTodoRegistos.
		System.out.println("########################### .findAll() buscarTodoRegistos() los Registros ##############################");

		// Busca todas las entidades de tipo Categoria en el repositorio.
		Iterable<Categoria> categoria = this.repositorioCategoria.findAll();

		// Itera sobre todas las entidades encontradas y las imprime en la consola.
		for (Categoria temporalCategoria : categoria){
			System.out.println("temporalCategoria ==> " + temporalCategoria);
		}
	}

	private void existeId() {
		// Imprime un mensaje en la consola para indicar que se está ejecutando el método existeId.
		System.out.println("########################### .existsById(....) existeId() en Registro ##############################");

		// Define el ID que se desea verificar si existe en el repositorio.
		Integer id = 125;

		// Verifica si existe una entidad con el ID especificado en el repositorio.
		boolean siExisteId = this.repositorioCategoria.existsById(id);

		// Si el ID existe, imprime un mensaje indicando que sí existe.
		if (siExisteId){
			System.out.println("repositorio.existsById() ==>  SI existe el id= " + id + "(" + siExisteId + ")");
		} else{
			// Si el ID no existe, imprime un mensaje indicando que no existe.
			System.out.println("repositorio.existsById() ==>  No existe el id= " + id + "(" + siExisteId + ")");
		}
	}

	private List<Categoria> obtenerListaCategoria() {
		// Crea una lista vacía de categorías.
		List<Categoria> listaCategorias = new LinkedList<>();

		// Imprime la lista vacía en la consola (útil para depuración).
		System.out.println("lista ==> " + listaCategorias);

		// Crea una nueva instancia de Categoria y establece sus propiedades (nombre y descripción).
		Categoria categoria_1 = new Categoria();
		categoria_1.setNombre("Programador Java/C# - .Net, Spring Frame Work, Spring Boot ");
		categoria_1.setDescripcion("Trabajo relacionado con el desarrollo de un sistema de empleo (APP)");

		// Crea otra instancia de Categoria y establece sus propiedades.
		Categoria categoria_2 = new Categoria();
		categoria_2.setNombre("Programador WEB BackEnd Java - Spring Frame Work, Spring Boot");
		categoria_2.setDescripcion("Trabajo relacionado con el desarrollo de un sistema de empleo (APP)");

		// Crea otra instancia de Categoria y establece sus propiedades.
		Categoria categoria_3 = new Categoria();
		categoria_3.setNombre("Programador WEB FrontEnd Java - Spring Boot");
		categoria_3.setDescripcion("Trabajo relacionado con el desarrollo de un sistema de empleo (APP)");

		// Crea otra instancia de Categoria y establece sus propiedades.
		Categoria categoria_4 = new Categoria();
		categoria_4.setNombre("Programador Java-EE");
		categoria_4.setDescripcion("Trabajo relacionado con el desarrollo de un sistema de empleo (APP) a nivel OfLine");

		// Crea otra instancia de Categoria y establece sus propiedades.
		Categoria categoria_5 = new Categoria();
		categoria_5.setNombre("Programador WEB PhP");
		categoria_5.setDescripcion("Trabajo relacionado con el desarrollo de un sistema de empleo (APP)");


		// Crea otra instancia de Categoria y establece sus propiedades.
		Categoria categoria_6 = new Categoria();
		categoria_6.setNombre("Programador WEB  JavaScript Node");
		categoria_6.setDescripcion("Trabajo relacionado con el desarrollo de un sistema de empleo (APP)");

		// Agrega las categorías creadas a la lista.
		listaCategorias.add(categoria_1);
		listaCategorias.add(categoria_2);
		listaCategorias.add(categoria_3);
		listaCategorias.add(categoria_4);
		listaCategorias.add(categoria_5);
		listaCategorias.add(categoria_6);

		// Imprime la lista de categorías en la consola (útil para depuración).
		System.out.println("listaCategorias ==> " + listaCategorias);

		// Devuelve la lista de categorías.
		return listaCategorias;
	}

	private void guardarTodasInstacias() {
		// Imprime un mensaje en la consola para indicar que se está ejecutando el método guardarTodasInstacias.
		System.out.println("########################### .saveAll(....) guardarTodasInstacias() Registro ##############################");

		// Obtiene una lista de categorías utilizando el método obtenerListaCategoria.
		List<Categoria> listaNuevasCategorias = this.obtenerListaCategoria();

		// Guarda todas las categorías de la lista en el repositorio.
		this.repositorioCategoria.saveAll(listaNuevasCategorias);
	}





	// ******** Ejemplos Utilizado extendiendo de la Interfaz JpaRepository en vez de de la intefaz CrudRepository
	// *************
	private void buscarTodosJpa() {
		// Este método se llama buscarTodosJpa y es privado, es decir, solo puede ser llamado dentro de la clase en la que está
		// definido.

		System.out.println("########################### .findAll() buscarTodosJpa()  Registro ##############################");
		// Esta línea imprime un mensaje en la consola para indicar que el método buscarTodosJpa está siendo ejecutado.

		List<Categoria> categoriasJpa = this.repositorioCategoria.findAll();
		// Aquí se declara una lista de objetos de tipo Categoria y se inicializa con el resultado del método findAll() del
		// repositorio.
		// El repositorio es una instancia de algún objeto que gestiona las operaciones de la base de datos.

		System.out.println("categoriasJpa ==>" + categoriasJpa);
		// Esta línea imprime en la consola el contenido de la lista categoriasJpa.

		for (Categoria categoriasJpaTemp : categoriasJpa){
			// Este es un bucle for-each que recorre cada objeto de tipo Categoria en la lista categoriasJpa.

			System.out.println("categoriasJpaTemp ==>" + categoriasJpaTemp);
			// Imprime en la consola el objeto actual de la lista.

			System.out.println(categoriasJpaTemp.getId() + " " + categoriasJpaTemp.getNombre());
			// Imprime en la consola el id y el nombre del objeto actual. Se asume que la clase Categoria tiene métodos getId() y
			// getNombre().
		}
		// El bucle for-each termina aquí.
	}


	private void borrarTodoRegistrosBloqueJpa() {
		System.out.println("########################### deleteAllInBatch() borrarTodoRegistrosBloque() ##############################");
		// Esta línea imprime un mensaje en la consola para indicar que el método borrarTodoRegistrosBloque() está siendo
		// ejecutado.

		// Imprimir y eliminar registros en bloque
		List<Categoria> categoriasJpaAntes = this.repositorioCategoria.findAll();
		System.out.println("categoriasJpa antes ==> " + categoriasJpaAntes);

		this.repositorioCategoria.deleteAllInBatch();

		List<Categoria> categoriasJpaDespues = this.repositorioCategoria.findAll();
		System.out.println("categoriasJpa después ==> " + categoriasJpaDespues);
	}




	private void buscarTodoOrdenadoJpa() {


		System.out.println("########################### .findAll(....) buscarTodoOrdenadoJpa()  Registro ##############################");
		// Esta línea imprime un mensaje en la consola para indicar que el método buscarTodoOrdenadoJpa está siendo ejecutado.

		List<Categoria> categoriasJpa = this.repositorioCategoria.findAll(); // ordenadas acendentemente por Ids
		// List<Categoria> categoriasJpa = this.repositorio.findAll(Sort.by("nombre")); // ordenadas acendentemente por Nombre
		// List<Categoria> categoriasJpa = this.repositorio.findAll(Sort.by("nombre").descending()); // ordenadas
		// decendentemente por Nombre
		// Aquí se declara una lista de objetos de tipo Categoria y se inicializa con el resultado del método findAll() del
		// repositorio.
		// El repositorio es una instancia de algún objeto que gestiona las operaciones de la base de datos.

		System.out.println();
		System.out.println("categoriasJpa ==>" + categoriasJpa);
		System.out.println();
		System.out.println();
		// Esta línea imprime en la consola el contenido de la lista categoriasJpa.

		for (Categoria categoriasJpaTemp : categoriasJpa){
			// Este es un bucle for-each que recorre cada objeto de tipo Categoria en la lista categoriasJpa.

			// System.out.println("categoriasJpaTemp ==>" + categoriasJpaTemp);
			// Imprime en la consola el objeto actual de la lista.

			System.out.println(categoriasJpaTemp.getId() + " " + categoriasJpaTemp.getNombre());
			// Imprime en la consola el id y el nombre del objeto actual. Se asume que la clase Categoria tiene métodos getId() y
			// getNombre().
		}
		// El bucle for-each termina aquí.
		System.out.println();
		System.out.println();

	}


	private void buscarTodoSoloPaginacion() {
		System.out.println("########################### .findAll(....) buscarTodoSoloPaginacion()  Registro ##############################");
		// Esta línea imprime un mensaje en la consola para indicar que el método buscarTodoSoloPaginacion está siendo
		// ejecutado.
		System.out.println();
		System.out.println();
		Page<Categoria> paginacion = this.repositorioCategoria.findAll(PageRequest.of(1, 6));

		for (Categoria subListaPaginada : paginacion.getContent()){

			System.out.println(subListaPaginada.getId() + "" + subListaPaginada.getNombre());

		}
		System.out.println();
		System.out.println("Total Registros en BD: " + paginacion.getTotalElements());
		System.out.println("Registro por Página: " + paginacion.getSize());
		System.out.println("Total Páginas: " + paginacion.getTotalPages());
		System.out.println();
		System.out.println();
	}


	private void buscarTodosPaginacionOrdenamineto() {
		System.out.println("########################### .findAll(....) buscarTodosPaginacionOrdenamineto()  Registro ##############################");
		// Esta línea imprime un mensaje en la consola para indicar que el método buscarTodosPaginacionOrdenamineto está siendo
		// ejecutado.
		System.out.println();
		System.out.println();
		// Page<Categoria> paginacion = this.repositorio.findAll(PageRequest.of(1, 4, Sort.by("nombre")));
		// ordenadas decendentemente por Nombre
		Page<Categoria> paginacion = this.repositorioCategoria.findAll(PageRequest.of(1, 6, Sort.by("nombre").descending()));
		for (Categoria subListaPaginada : paginacion.getContent()){

			System.out.println(subListaPaginada.getId() + "" + subListaPaginada.getNombre());

		}
		System.out.println();
		System.out.println("Total Registros en BD: " + paginacion.getTotalElements());
		System.out.println("Registro por Página: " + paginacion.getSize());
		System.out.println("Total Páginas: " + paginacion.getTotalPages());
		System.out.println();
		System.out.println();
	}






	// Declaración del método privado llamado buscarVacantes que no devuelve ningún valor
	// Declaración del método privado llamado buscarVacantes que no devuelve ningún valor
	private void buscarVacantes() {
		// Imprime un mensaje en la consola para indicar que se está ejecutando el método buscarVacantes
		System.out.println("########################### .findAll() buscarVacantes() los Registros ##############################");

		// Busca todas las entidades de tipo Vacante en el repositorio
		System.out.println(); // Imprime una línea vacía en la consola
		System.out.println(); // Imprime otra línea vacía en la consola

		// Declara una lista de objetos de tipo Vacante y la inicializa con el resultado de findAll() del repositorio
		List<Vacante> listVacante = this.repositorioVacante.findAll();
		System.out.println(); // Imprime una línea vacía en la consola
		System.out.println(); // Imprime otra línea vacía en la consola

		// Inicia un bucle for para iterar sobre cada objeto de tipo Vacante en la lista
		for (Vacante temporalLikstVacante : listVacante){
			// Comentado: ejemplo de cómo imprimir toda la información del objeto
			// System.out.println("temporalCategoria ==> " + temporalLikstVacante);

			// Imprime el ID, el nombre de la vacante y el nombre de la categoría de cada objeto Vacante
			System.out.println(temporalLikstVacante.getId() + " " + temporalLikstVacante.getNombre() + "--> " + temporalLikstVacante.getCategoria().getNombre());
		}
		// Fin del bucle for
		System.out.println(); // Imprime una línea vacía en la consola
		System.out.println(); // Imprime otra línea vacía en la consola
		// Fin del método buscarVacantes
	}

	private void crearVacante() {
		// Imprime un mensaje en la consola para indicar que se está ejecutando el método crearVacantes()
		System.out.println("########################### . save() crearVacantes() ##############################");

		// Imprime una línea vacía en la consola
		System.out.println();
		// Imprime otra línea vacía en la consola
		System.out.println();

		// Crea una nueva instancia de la clase Vacante
		Vacante vacante = new Vacante();

		// Establece el nombre de la vacante como "Programador SQL"
		vacante.setNombre("Programador Php (Laravel)");

		// Establece la descripción de la vacante
		vacante.setDescripcion("Desarrollador BackEnd Php laravel");

		// Establece la fecha actual como la fecha de la vacante
		vacante.setFecha(new Date());

		// Establece el salario de la vacante como 8500.0
		vacante.setSalario(8500.0);

		// Establece el estado de la vacante como "Aprobada"
		vacante.setStatus("Aprobada");

		// Establece el campo destacado de la vacante como 0 (no destacado)
		vacante.setDestacado(0);

		// Establece la imagen de la vacante como "escuela.png"
		vacante.setImages("escuela.png");

		// Establece El detalle de la vacante
		vacante.setDetalles("<h1> los  requisitos  para el desarrollador Php (Laravel) </h1>");



		// Crea una nueva instancia de la clase Categoria
		Categoria categoria = new Categoria();
		System.out.println("categoria ==> " + categoria);

		// Establece el ID de la categoría como 8
		categoria.setId(8);

		// Establece la categoría de la vacante
		vacante.setCategoria(categoria);

		// Guarda la vacante en el repositorio
		this.repositorioVacante.save(vacante);
	}


	private void guardarVacante() {
		this.crearVacante();

	}

	private void crearPerfilesAplicacion() {

		System.out.println("########################### .save(?) crearPerfilesAplicacion() Registro ##############################");
		this.repositorioPerfiles.saveAll(this.getPerfilesAplicacion());
		System.out.println("IR_PerfilesRepository ==>" + this.repositorioPerfiles);


	}

	private List<Perfil> getPerfilesAplicacion() {
		List<Perfil> listaPerfiles = new LinkedList<>();

		Perfil perfil1 = new Perfil();
		perfil1.setPerfil("SUPERVISOR");

		Perfil perfil2 = new Perfil();
		perfil2.setPerfil("ADMINISTRADOR");

		Perfil perfil3 = new Perfil();
		perfil3.setPerfil("USUARIO");

		listaPerfiles.add(perfil1);
		listaPerfiles.add(perfil2);
		listaPerfiles.add(perfil3);



		System.out.println(listaPerfiles);
		return listaPerfiles;


	}

	// Perfil Supervisor
	private void crearUsuarioConUnPerfil() {
		Usuarios perfilUsuario = new Usuarios();


		perfilUsuario.setNombre("Ivor Guzmán");
		perfilUsuario.setEmail("ivorguzman@gmail.com");
		perfilUsuario.setFechaDeRegistro(new Date());
		perfilUsuario.setUserName("ivor");
		perfilUsuario.setPassWord("123");
		perfilUsuario.setEstatus(1);


		System.out.println();
		System.out.println("########################### .  crearUsuarioConUnPerfil()  ##############################");
		System.out.println("perfilUsuario.getNombre() ==> " + perfilUsuario.getNombre());
		System.out.println("perfilUsuario.getEmail() ==> " + perfilUsuario.getEmail());
		System.out.println("perfilUsuario.getFechaDeRegistro() ==> " + perfilUsuario.getFechaDeRegistro());
		System.out.println("perfilUsuario.getUserName() ==> " + perfilUsuario.getUserName());
		System.out.println("perfilUsuario.getPassWord() ==> " + perfilUsuario.getPassWord());
		System.out.println("perfilUsuario.getEstatus() ==> " + perfilUsuario.getEstatus());
		System.out.println();
		System.out.println();






	}


}


















