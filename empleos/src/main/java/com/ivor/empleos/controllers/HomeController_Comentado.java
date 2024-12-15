/*
 * package com.ivor.empleos.controllers; // Paquete en el que se encuentra la clase
 * 
 * import java.text.SimpleDateFormat; // Importa la clase SimpleDateFormat para formatear fechas
 * import java.util.Date; // Importa la clase Date para manejar fechas
 * import java.util.LinkedList; // Importa la clase LinkedList para manejar listas enlazadas
 * import java.util.List; // Importa la interfaz List para manejar listas genéricas
 * 
 * import org.springframework.stereotype.Controller; // Importa la anotación @Controller de Spring
 * import org.springframework.ui.Model; // Importa la interfaz Model de Spring para pasar datos a la vista
 * import org.springframework.web.bind.annotation.GetMapping; // Importa la anotación @GetMapping para manejar solicitudes GET
 * 
 * import com.ivor.empleos.model.Vacante; // Importa la clase Vacante del paquete model
 * 
 * @Controller // Indica que esta clase es un controlador de Spring
 * public class HomeController_Comentado { // Declaración de la clase HomeController
 * 
 * @GetMapping("/detalle") // Mapea la URL "/detalle" a este método
 * public String mostrarDetalle(Model modelo) { // Método que maneja la solicitud GET para "/detalle"
 * 
 * Vacante vacanteA = new Vacante(); // Crea una nueva instancia de Vacante llamada vacanteA
 * Vacante vacanteB = new Vacante(); // Crea una nueva instancia de Vacante llamada vacanteB
 * 
 * vacanteA.setNombre("Ing. de Comunicaciones"); // Establece el nombre de vacanteA
 * vacanteA.setDescripcion("Ing. para dar soporte a Intranet"); // Establece la descripción de vacanteA
 * vacanteA.setFecha(new Date()); // Establece la fecha actual para vacanteA
 * vacanteA.setSalario(9700000.0); // Establece el salario para vacanteA
 * modelo.addAttribute("vacanteA", vacanteA); // Añade vacanteA al modelo
 * 
 * vacanteB.setNombre("Ing. de SoftWare"); // Establece el nombre de vacanteB
 * vacanteB.setDescripcion("Ing. para dar soporte a sistema Bancario"); // Establece la descripción de vacanteB
 * vacanteB.setFecha(new Date()); // Establece la fecha actual para vacanteB
 * vacanteB.setSalario(9999999.0); // Establece el salario para vacanteB
 * modelo.addAttribute("vacanteB", vacanteB); // Añade vacanteB al modelo
 * 
 * return "detalle"; // Devuelve el nombre de la vista "detalle"
 * }
 * 
 * @GetMapping("/listado") // Mapea la URL "/listado" a este método
 * public String mostrarListado(Model modelo) { // Método que maneja la solicitud GET para "/listado"
 * 
 * List<String> lista = new LinkedList<>(); // Crea una nueva lista enlazada de strings
 * lista.add("Ingeniero de SoftWare"); // Añade "Ingeniero de SoftWare" a la lista
 * lista.add("Auxiliar Contable"); // Añade "Auxiliar Contable" a la lista
 * lista.add("Técnico en PCs"); // Añade "Técnico en PCs" a la lista
 * lista.add("Arquitecto"); // Añade "Arquitecto" a la lista
 * modelo.addAttribute("empleos", lista); // Añade la lista de empleos al modelo
 * 
 * return "listado"; // Devuelve el nombre de la vista "listado"
 * }
 * 
 * @GetMapping("/") // Mapea la URL raíz "/" a este método
 * public String mostrarHome(Model modelo) { // Método que maneja la solicitud GET para la raíz
 * 
 * String nombre = "Auxiliar contable"; // Define el nombre del empleo
 * Date fechaPublicacion = new Date(); // Define la fecha de publicación actual
 * double salario = 9000.0; // Define el salario del empleo
 * boolean vigente = true; // Define si el empleo está vigente
 * 
 * modelo.addAttribute("nombre", nombre); // Añade el nombre del empleo al modelo
 * modelo.addAttribute("fechaPublicacion", fechaPublicacion); // Añade la fecha de publicación al modelo
 * modelo.addAttribute("salario", salario); // Añade el salario al modelo
 * modelo.addAttribute("vigente", vigente); // Añade el estado de vigencia al modelo
 * 
 * return "home"; // Devuelve el nombre de la vista "home"
 * }
 * 
 * private List<Vacante> getVacante() { // Método privado para obtener una lista de vacantes (aún no implementado)
 * SimpleDateFormat sdf = new SimpleDateFormat(); // Crea una instancia de SimpleDateFormat
 * 
 * // Código faltante...
 * 
 * return null; // Devuelve null (indicando que el método aún no está implementado)
 * }
 * 
 * 
 * Explicación Detallada
 * Paquete y Importaciones
 * 
 * Define el paquete y las clases necesarias para el funcionamiento del controlador.
 * 
 * Anotación @Controller
 * 
 * Marca la clase HomeController como un controlador de Spring que maneja solicitudes web.
 * 
 * Método mostrarDetalle
 * 
 * @GetMapping("/detalle"): Mapea la URL "/detalle" a este método.
 * 
 * Creación de Vacantes: Crea dos objetos Vacante, establece sus propiedades y los añade al modelo.
 * 
 * Retorno: Devuelve el nombre de la vista "detalle".
 * 
 * Método mostrarListado
 * 
 * @GetMapping("/listado"): Mapea la URL "/listado" a este método.
 * 
 * Creación de Lista: Crea una lista de cadenas con nombres de empleos y la añade al modelo.
 * 
 * Retorno: Devuelve el nombre de la vista "listado".
 * 
 * Método mostrarHome
 * 
 * @GetMapping("/"): Mapea la URL raíz "/" a este método.
 * 
 * Definición de Atributos: Define atributos como nombre, fecha de publicación, salario y estado de vigencia y los añade al modelo.
 * 
 * Retorno: Devuelve el nombre de la vista "home".
 * 
 * Método getVacante
 * 
 * No Implementado: Este método está definido pero no implementado, solo crea una instancia de SimpleDateFormat y devuelve null.
 * 
 * }
 */
