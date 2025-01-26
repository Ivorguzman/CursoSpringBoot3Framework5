package com.ivor.empleos.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	public static String guardarArchivo(MultipartFile multiPart, String ruta) {
		String nombreOriginal= multiPart.getOriginalFilename ();
		try{
			File imageFile= new File (ruta + nombreOriginal);
			multiPart.transferTo (imageFile);
			return nombreOriginal;
		}catch(IOException ex){
			System.out.println ("ERROR:" + ex.getMessage ());
			System.out.println ("ERROR:" + ex.getStackTrace ());
		}


		return null;
	}

}
