package com.ivor.empleos.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ivor.empleos.model.Categoria;


@Service
public class CategoriaServiceImp implements I_CategoriaService {


	private List<Categoria> listaCategorias = null; // Atributo a nivel de la clase
	/*
	 * List<Categoria>:
	 * LinkedList es una clase concreta que implementa la interfaz List.
	 * La asignación funciona debido al principio del polimorfismo,
	 * que permite que una variable de tipo interfaz pueda referirse
	 * a cualquier objeto cuya clase implemente esa interfaz.
	 * 
	 *
	 * new LinkedList<>():
	 * Crea una nueva instancia de LinkedList<Categoria> y la asigna a la variable
	 * listaCategorias.
	 * LinkedList es una implementación concreta de la interfaz List.
	 */

	// ******************* Contructor ********************************
	public CategoriaServiceImp( ) {

		this.listaCategorias = new LinkedList<Categoria>();

		// Crear categoria 1
		Categoria categoria1 = new Categoria();
		categoria1.setId(1);
		categoria1.setNombre("Ventas");
		categoria1.setDescripcion(null);
		// Crear categoria 2
		Categoria categoria2 = new Categoria();
		categoria2.setId(2);
		categoria2.setNombre("Contabilidad");
		categoria2.setDescripcion(null);
		// Crear categoria 3
		Categoria categoria3 = new Categoria();
		categoria3.setId(3);
		categoria3.setNombre("Transporte");
		categoria3.setDescripcion(null);
		// Crear categoria 4
		Categoria categoria4 = new Categoria();
		categoria4.setId(4);
		categoria4.setNombre("Informática");
		categoria4.setDescripcion(null);
		// Crear categoria 5
		Categoria categoria5 = new Categoria();
		categoria5.setId(5);
		categoria5.setNombre("Construcción");
		categoria5.setDescripcion(null);
		// Crear categoria 6
		Categoria categoria6 = new Categoria();
		categoria6.setId(6);
		categoria6.setNombre("Desarrollo Java (Java Spring)");
		categoria6.setDescripcion(null);

		this.listaCategorias.add(categoria1);
		this.listaCategorias.add(categoria2);
		this.listaCategorias.add(categoria3);
		this.listaCategorias.add(categoria4);
		this.listaCategorias.add(categoria5);
		this.listaCategorias.add(categoria6);

	}



	@Override
	public void guardar(Categoria categoria) {
		this.listaCategorias.add(categoria);
		System.out.println("categoria_MetodoGuardar() = " + this.listaCategorias);
		System.out.println();

	}


	@Override
	public List<Categoria> buscarTodas() {
		System.out.println();
		System.out.println("CategoriaServiceImp.java <<buscarTodas()>> : " + this.listaCategorias);
		System.out.println();
		return this.listaCategorias;
	}


	@Override
	public Categoria buscarPorID(Integer idCategoria) {
		for (Categoria _categoria : this.listaCategorias){

			if (_categoria.getId() == idCategoria){
				return _categoria;
			}
		}
		return null;
	}
}
