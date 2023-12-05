package com.uce.edu.service;

import com.uce.edu.repository.modelo.Vehiculo;

public interface IVehiculoService {
	// CRUD
	public Vehiculo buscar(String placa);

	public void guardar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public void eliminar(String placa);
}
