package com.ivor.empleos.service;

import java.util.List;

import com.ivor.empleos.model.Vacante;

public interface I_Vacanteservice {

	List<Vacante> buscarTodasVacante();

	Vacante buscarVarPorIdVacante(Integer idVacante);

}


