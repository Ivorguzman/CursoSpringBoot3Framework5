package com.ivor.empleos.service;

import java.util.List;

import com.ivor.empleos.model.Vacante;

public interface I_VacanteService {

	List<Vacante> buscarTodasVacante();

	Vacante buscarVarPorIdVacante(Integer idVacante);

	void guardar(Vacante vacante);

}


