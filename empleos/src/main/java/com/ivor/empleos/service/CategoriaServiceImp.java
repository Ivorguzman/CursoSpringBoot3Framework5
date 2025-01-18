package com.ivor.empleos.service;

import java.util.LinkedList;
import java.util.List;

import com.ivor.empleos.model.Categoria;

public class CategoriaServiceImp implements I_CategoriaService {


	private List<Categoria> catgoria= null;
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

// ** Constructor **
	public CategoriaServiceImp( ) {
		this.catgoria= new LinkedList<Categoria> ();



	}







	@Override
	public void guardar(Categoria categoria) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Categoria> buscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria buscarPorID(Integer idCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
