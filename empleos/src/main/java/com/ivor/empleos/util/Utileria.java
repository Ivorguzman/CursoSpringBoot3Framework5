package com.ivor.empleos.util; // Define el paquete de la clase

import java.io.File;
import java.io.IOException; // Importa IOException para manejar errores de entrada/salida

import org.springframework.web.multipart.MultipartFile; // Importa MultipartFile para manejar archivos subidos

public class Utileria { // Declara la clase Utileria

	/*
	 * public static String guardarArchivo(MultipartFile multiPart, String
	 * ruta){
	 * Declara un método público y estático llamado guardarArchivo. Recibe un
	 * objeto MultipartFile (el archivo a guardar) y una cadena ruta (la ruta
	 * donde se guardará el archivo). Devuelve un String, que en este caso será
	 * el nombre del archivo guardado.
	 * 
	 * * MultipartFile es una interfaz proporcionada por Spring para manejar
	 * archivos subidos. Este tipo de dato permite que el controlador reciba el
	 * archivo en su forma binaria, que luego puede ser guardada en el sistema
	 * de archivos, una base de datos, o procesada de otra manera según sea
	 * necesario.
	 */
	public static String guardarArchivo(MultipartFile multiPart, String ruta) {

		/*
		 * Método getOriginalFilename():
		 * Este método es llamado sobre el objeto multiPart y su propósito es
		 * obtener el nombre original del archivo tal como fue subido por el
		 * usuario.
		 * Devuelve un String que representa el nombre del archivo original que el
		 * usuario seleccionó. Por ejemplo, si un usuario sube un archivo llamado
		 * nombreDelAchivo.png, el método devolverá la cadena "nombreDelAchivo.png".
		 */
		String nombreOriginal = multiPart.getOriginalFilename();
		System.out.println("nombreOriginal =" + nombreOriginal);
		// Asigna el resultado del reemplazo a una nueva variable
		String nombreSinEspacios = nombreOriginal.replace(" ", "_");
		System.out.println("nombreOriginal (replace) = " + nombreSinEspacios);
		String nombreDefinitivo = randomAlphaNumeric(8) + nombreSinEspacios;

		// Inicia un bloque try para manejar excepciones
		try{

			/*
			 * File imageFile= new File(ruta + nombreOriginal);: Crea un nuevo objeto
			 * File con la ruta especificada concatenada con el nombre original del
			 * archivo. Este objeto representa el archivo que se va a guardar en el
			 * sistema.
			 * String imageFile = ruta + File.separator + nombreOriginal;
			 * File imageFile = new File(rutaCompleta);
			 * 
			 * 
			 * File.separator es una propiedad en Java que te proporciona el separador
			 * de rutas de archivo del sistema operativo donde se está ejecutando el
			 * programa. Esto es útil porque diferentes sistemas operativos usan
			 * diferentes caracteres para separar los directorios en una ruta de
			 * archivo.
			 * 
			 * En resumen, File.separator asegura que tu código de manejo de archivos
			 * (esto obtiene el separador de directorios apropiado para el sistema
			 * operativo que se usa funcione correctamente, independientemente de dónde
			 * lo estés ejecutando ejemplo, \ en windows y / en Unix/Linux).
			 * 
			 */
			File imageFile = new File(ruta + File.separator + nombreDefinitivo);

			System.out.println("ruta =" + ruta);
			System.out.println("imageFilel =" + imageFile);


			/*
			 * multiPart.transferTo(imageFile);: Transfiere el contenido del archivo
			 * multiPart al archivo imageFile en el sistema de archivos. Esto guarda el
			 * archivo.
			 */
			multiPart.transferTo(imageFile);
		} catch(IOException ex){ // Maneja excepciones de entrada/salida
			System.out.println("ERROR:" + ex.getMessage()); // Imprime el mensaje de error
			System.out.println("ERROR:" + ex.getStackTrace()); // Imprime el rastreo de la pila del error
			return null; // Retorna null si hubo un error
		}
		/*
		 * System.out.println("ruta + nombreOriginal =" + ruta + "/" + nombreDefinitivo);
		 */
		System.out.println("ruta + nombreOriginal =" + ruta + nombreDefinitivo);
		return nombreDefinitivo;

	}
	/*
	 * Resumen de la función
	 * La función randomAlphaNumeric genera una cadena de caracteres aleatorios alfanuméricos (letras y números) de longitud
	 * especificada por el parámetro count. Utiliza un ciclo para seleccionar aleatoriamente caracteres de una cadena
	 * predefinida y los agrega a un objeto StringBuilder. Finalmente, devuelve la cadena resultante como una String.
	 */

	public static String randomAlphaNumeric(int count) {
		// Define una cadena que contiene los caracteres alfanuméricos permitidos (A-Z y 0-9).
		String alfanumericos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		// Crea un objeto StringBuilder, que se utilizará para construir la cadena de caracteres aleatorios.
		StringBuilder builder = new StringBuilder();

		// Un ciclo que se repetirá 'count' veces, decrementando 'count' en cada iteración.
		while (count-- != 0){
			// Genera un número aleatorio dentro del rango de los índices de la cadena 'alfanumericos'.
			int agregarCaracter = (int) (Math.random() * alfanumericos.length());

			// Añade el carácter aleatorio seleccionado a la cadena en construcción 'builder'.
			builder.append(alfanumericos.charAt(agregarCaracter));
		}

		// Convierte el contenido de 'builder' en una cadena de texto y la devuelve.
		return builder.toString();
	}

}

