package com.uce.edu.service;

import com.uce.edu.repository.modelo.Propietario;

public interface IPropietarioService {
	// CRUD "Crear y Actualizar"
	public Propietario buscar(String cedula);

	public void guardar(Propietario propietario);

	 public void actualizar(Propietario propietario);

	public void eliminar(String cedula);
}
