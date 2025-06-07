package com.ivor.empleos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// ****************** ANOTACIÓN PRINCIPAL ******************

// @SpringBootApplication: Marca esta clase como la aplicación principal en Spring Boot.
// Significa que esta clase contendrá la configuración principal y el punto de entrada de la aplicación.
// Esta anotación combina tres otras anotaciones en Spring:
// - @EnableAutoConfiguration → Habilita la configuración automática basada en las dependencias del proyecto.
// - @ComponentScan → Permite la detección automática de componentes, servicios y controladores dentro del paquete.
// - @Configuration → Indica que esta clase puede definir configuraciones de la aplicación.
@SpringBootApplication
public class EmpleosApplication { // Declaramos la clase pública "EmpleosApplication"

	// ****************** MÉTODO PRINCIPAL ******************

	// public static void main(String[] args)
	// - public → El método es accesible desde cualquier parte del programa.
	// - static → Se puede ejecutar sin necesidad de crear un objeto de la clase.
	// - void → No devuelve ningún valor.
	// - main → Es el punto de entrada de la aplicación en Java.
	// - String[] args → Representa los argumentos que pueden pasarse a la aplicación desde la línea de comandos.
	public static void main(String[] args) {

		// SpringApplication.run(EmpleosApplication.class, args);
		// - SpringApplication → Es una clase de utilidad de Spring Boot que permite iniciar la aplicación.
		// - .run(EmpleosApplication.class, args) → Ejecuta la aplicación con la configuración definida en "EmpleosApplication".
		// - EmpleosApplication.class → Es la clase principal de la aplicación que contiene la configuración.
		// - args → Pasamos los argumentos recibidos al iniciar la aplicación.
		SpringApplication.run(EmpleosApplication.class, args);
	}
}

