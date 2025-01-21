package com.ivor.empleos.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ivor.empleos.model.Categoria;


@Service
public class CategoriaServiceImp implements I_CategoriaService {


	private List<Categoria> categoria= null; // Atributo a nivel de la clase
	/*
	 * List<Vacante>:
	 * LinkedList es una clase concreta que implementa la interfaz List.
	 * La asignación funciona debido al principio del polimorfismo,
	 * que permite que una variable de tipo interfaz pueda referirse
	 * a cualquier objeto cuya clase implemente esa interfaz.
	 * 
	 *
	 * new LinkedList<>():
	 * Crea una nueva instancia de LinkedList<Vacante> y la asigna a la variable
	 * lista.
	 * LinkedList es una implementación concreta de la interfaz List.
	 */

	// ******************* Contructor ********************************
	public CategoriaServiceImp( ) {

		this.categoria= new LinkedList<Categoria> ();

		// Crear categoria 1
		Categoria categoria1= new Categoria ();
		categoria1.setId (1);
		categoria1.setNombre ("Ventas");
		categoria1.setDescripcion (null);
		// Crear categoria 2
		Categoria categoria2= new Categoria ();
		categoria2.setId (2);
		categoria2.setNombre ("Contabilidad");
		categoria2.setDescripcion (null);
		// Crear categoria 3
		Categoria categoria3= new Categoria ();
		categoria3.setId (3);
		categoria3.setNombre ("Transporte");
		categoria3.setDescripcion (null);
		// Crear categoria 4
		Categoria categoria4= new Categoria ();
		categoria4.setId (4);
		categoria4.setNombre ("Informática");
		categoria4.setDescripcion (null);
		// Crear categoria 5
		Categoria categoria5= new Categoria ();
		categoria5.setId (5);
		categoria5.setNombre ("Construcción");
		categoria5.setDescripcion (null);
		// Crear categoria 6
		Categoria categoria6= new Categoria ();
		categoria5.setId (6);
		categoria5.setNombre ("Desarrollo Web (Java Spring)");
		categoria5.setDescripcion (null);

		this.categoria.add (categoria1);
		this.categoria.add (categoria2);
		this.categoria.add (categoria3);
		this.categoria.add (categoria4);
		this.categoria.add (categoria5);
		this.categoria.add (categoria6);

	}



	@Override
	public void guardar(Categoria categoria) {
		this.categoria.add (categoria);
		System.out.println ("categoria_MetodoGuardar() = " + this.categoria);
		System.out.println ();

	}


	@Override
	public List<Categoria> buscarTodas() {

		return this.categoria;
	}


	@Override
	public Categoria buscarPorID(Integer idCategoria) {
		for (Categoria _categoria : this.categoria){
			
			if (_categoria.getId () == idCategoria){
				return _categoria;
			}
		}
		return null;
	}
}
