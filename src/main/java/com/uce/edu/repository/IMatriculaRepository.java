package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Matricula;

public interface IMatriculaRepository {
	// CRUD
	public Matricula seleccionar(String noMatricula);

	public void insertar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void eliminar(String noMatricula);
	
	
}
