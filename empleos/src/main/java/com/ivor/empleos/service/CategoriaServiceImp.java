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
