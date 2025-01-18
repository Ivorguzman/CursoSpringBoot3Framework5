package com.ivor.empleos.service;

import java.util.List;

import com.ivor.empleos.model.Categoria;

public interface I_CategoriaService {

	void guardar(Categoria categoria);

	List<Categoria> buscarTodas();

	Categoria buscarPorID(Integer idCategoria);

}
