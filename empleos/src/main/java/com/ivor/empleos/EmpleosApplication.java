package com.ivor.empleos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/*
 * El método main es el punto de entrada de la aplicación. Este método se ejecuta cuando inicias la aplicación.
 * 
 * SpringApplication.run(EmpleosApplication.class, args);: Este método inicia el contexto de la aplicación Spring.
 * Realiza varias tareas:
 * 
 * 1.Configura el contenedor de Spring.
 * 2.Escanea las clases anotadas en el paquete y sus subpaquetes.
 * 3.Crea y registra los beans necesarios en el contenedor.
 * 4.Inicia el servidor web embebido (como Tomcat, si estás construyendo una aplicación web).
 */
@SpringBootApplication
public class EmpleosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpleosApplication.class, args);
	}

}
