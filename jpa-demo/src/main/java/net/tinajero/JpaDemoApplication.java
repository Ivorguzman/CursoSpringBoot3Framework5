package net.tinajero;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.tinajero.model.Categoria;
import net.tinajero.repository.IR_CategoriaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	private IR_CategoriaRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("========================== > Ejecutando public void run(...){......} < =========================");
		// this.guardar();
		// this.buscarPorId();
		// this.modificar();
		// this.eliminar();
		// this.eliminarTodos();
		// this.contar();
		// this.econtrarEstosIds();
		// this.buscarTodoRegistos();
		// this.existeId();
		this.guardarTodasInstacias();
	}




	private void guardar() {

		System.out.println("########################### .save(?) guardar() Registro ##############################");
		Categoria catagoria = new Categoria();
		catagoria.setNombre("Finanzas");
		catagoria.setDescripcion("Trabajo de finanzas y contabilidad");
		this.repositorio.save(catagoria);
		System.out.println("I_CategoriaRepository repositorio ==>" + this.repositorio);
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
		Optional<Categoria> optional = this.repositorio.findById(2);

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
			this.repositorio.save(categoriaTemporal);
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
		System.out.println("########################### .findById(...) buscarPorId()  Registro ##############################");
		Optional<Categoria> optional = this.repositorio.findById(2);
		System.out.println(" Optional<Categoria> repositorio.findById(...) ==>  " + this.repositorio);
		if (optional.isPresent()){

			System.out.println("optional.get() ==> " + optional.get());
		} else{
			System.out.println("La Calse Categorio no se encontro");
		}


	}

	private void eliminar() {
		System.out.println("########################### deleteById(...) eliminar() Registro ##############################");
		int id = 18;

		this.repositorio.deleteById(id);
		System.out.println("deleteById(id) ==>  " + this.repositorio);


	}


	private void contar() {
		System.out.println("##### .count() Registro devuelve la cantidade de  entidades (registros) del tipo categorias(tables) estan almacenadas BD #####");
		long conteo = this.repositorio.count();
		System.out.println("this.repositorio.count() ==> " + conteo);

	}

	private void eliminarTodos() {
		System.out.println("########################### deleteAll() eliminarTodos() Registro ##############################");
		this.repositorio.deleteAll();
	}


	private void econtrarEstosIds() {
		System.out.println("########################### .findAllById(...) econtrarEstosIds()  en Registro ##############################");
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(14);
		ids.add(12);
		ids.add(13);
		Iterable<Categoria> categoria = this.repositorio.findAllById(ids);

		for (Categoria temporalCategoria : categoria){
			System.out.println("tempotralCategoria ==> " + temporalCategoria);


		}
	}



	private void buscarTodoRegistos() {
		System.out.println("########################### .findAll() buscarTodoRegistos() los Registro ##############################");
		Iterable<Categoria> categoria = this.repositorio.findAll();

		for (Categoria temporalCategoria : categoria){
			System.out.println("tempotralCategoria ==> " + temporalCategoria);


		}


	}


	private void existeId() {
		System.out.println("########################### .existsById(....) existeId() en Registro ##############################");

		Integer id = 125;
		boolean siExisteId = this.repositorio.existsById(id);

		if (siExisteId){

			System.out.println("repositorio.existsById() ==>  SI existe el id= " + id + "(" + siExisteId + ")");

		} else{
			System.out.println("repositorio.existsById() ==>  No existe el id= " + id + "(" + siExisteId + ")");
		}
	}

	private List<Categoria> obtenerListaCategoria() {

		List<Categoria> listaCategorias = new LinkedList<>();
		System.out.println("lista ==> " + listaCategorias);

		Categoria categoria_1 = new Categoria();
		categoria_1.setNombre("Programador Java/C# - .Net, Spring Frame Work, Spring Boot ");
		categoria_1.setDescripcion("Tabajo relacionado con el  desarrollo de un  sietemna de empleo (APP)");

		Categoria categoria_2 = new Categoria();
		categoria_2.setNombre("Programador WEB BackEnd  Java - Spring Frame Work , Spring Boot");
		categoria_2.setDescripcion("Tabajo relacionado con el  desarrollo de un  sietemna de empleo (APP)");


		Categoria categoria_3 = new Categoria();
		categoria_3.setNombre("Programador WEB FrontEnd  Java - Spring Boot");
		categoria_3.setDescripcion("Tabajo relacionado con el  desarrollo de un  sietemna de empleo (APP)");


		listaCategorias.add(categoria_1);
		listaCategorias.add(categoria_2);
		listaCategorias.add(categoria_3);

		System.out.println("listaCategorias ==> " + listaCategorias);
		return listaCategorias;
	}

	private void guardarTodasInstacias() {
		System.out.println("########################### .saveAll(....) guardarTodo()  Registro ##############################");
		List<Categoria> listaNuevasCategorias = this.obtenerListaCategoria();
		this.repositorio.saveAll(listaNuevasCategorias);

	}
}



















