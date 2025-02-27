package com.ivor.empleos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ivor.empleos.model.Vacante;

@Service
public class VacantesServiceImpl implements I_VacanteService {

	private List<Vacante> listaVacantes = null; // Atributo a nivel de la clase



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
	 * listaVacantes.
	 * LinkedList es una implementación concreta de la interfaz List.
	 */
	// ******************* Contructor ********************************
	public VacantesServiceImpl( ) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Formato de fecha

		this.listaVacantes = new LinkedList<Vacante>(); // Lista de vacantes


		try{
			// Crear vacante 1
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Solicitamos Ing. Civil con experiencia en vialidades");
			vacante1.setFecha(sdf.parse("06-12-2024"));
			vacante1.setSalario(3999.0);
			vacante1.setDestacado(1); // Vacante destacada
			vacante1.setImages("logo1.png");


			// Crear vacante 2
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Publico");
			vacante2.setDescripcion("Solicitamos Contador Fiscal con experiencia en IMPORTACIONES");
			vacante2.setFecha(sdf.parse("06-12-2024"));
			vacante2.setSalario(2999.0);
			vacante2.setDestacado(1); // Vacante destacada
			vacante2.setImages("logo2.png");

			// Crear vacante 3
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Electrico");
			vacante3.setDescripcion("Solicitamos Ing. Electrico con experiencia en Sistemas de ferrocarriles");
			vacante3.setFecha(sdf.parse("06-12-2024"));
			vacante3.setSalario(5999.0);
			vacante3.setDestacado(0); // Vacante no destacada
			vacante3.setImages("logo3.png");


			// Crear vacante 4
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador Gráfico");
			vacante4.setDescripcion("Solicitamos Diseñador con experiencia en diseño editorial e Impresión OffSet");
			vacante4.setFecha(sdf.parse("06-12-2024"));
			vacante4.setSalario(3999.0);
			vacante4.setDestacado(1); // Vacante destacada
			vacante4.setImages("logo4.png");



			this.listaVacantes.add(vacante1);
			this.listaVacantes.add(vacante2);
			this.listaVacantes.add(vacante3);
			this.listaVacantes.add(vacante4);



		} catch(ParseException ex){
			System.out.println("ERROR => : " + ex.getMessage()); // Maneja la excepción de parseo de fecha
		}
	}



	@Override
	public List<Vacante> buscarTodasVacante() {
		System.out.println("VacanteServiceImp.java [buscarTodasVacante()]=> return this.listaVacantes " + this.listaVacantes);
		System.out.println();
		return this.listaVacantes;
	}



	@Override
	public Vacante buscarVarPorIdVacante(Integer idVacante) {
		for (Vacante _vacante : this.listaVacantes){
			System.out.println("v_Vacante = " + _vacante);
			if (_vacante.getId() == idVacante){
				return _vacante;
			}
		}
		return null;
	}



	@Override
	public void guardar(Vacante vacante) {
		this.listaVacantes.add(vacante);
		System.out.println("lista_MetodoGuardar() = " + this.listaVacantes);
		System.out.println();
	}












}
