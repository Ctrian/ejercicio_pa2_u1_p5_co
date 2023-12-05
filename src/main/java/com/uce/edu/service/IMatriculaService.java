package com.uce.edu.service;

import com.uce.edu.repository.modelo.Matricula;

public interface IMatriculaService {
	// CRUD
	public Matricula buscar(String noMatricula);

	public void guardar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void eliminar(String noMatricula);
	
	public void matricular(String cedulaPropietario, String placaVehiculo);
}
