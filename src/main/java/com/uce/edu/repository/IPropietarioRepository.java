package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Propietario;

public interface IPropietarioRepository {
	// CRUD "Crear y Actualizar"
	public Propietario seleccionar(String cedula);

	public void insertar(Propietario propietario);

	 public void actualizar(Propietario propietario);

	public void eliminar(String cedula);
}
