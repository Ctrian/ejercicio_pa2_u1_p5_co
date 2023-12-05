package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.IPropietarioRepository;
import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Override
	public Matricula buscar(String noMatricula) {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionar(noMatricula);
	}

	@Override
	public void guardar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.insertar(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.actualizar(matricula);
	}

	@Override
	public void eliminar(String noMatricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.eliminar(noMatricula);
	}

	@Override
	public void matricular(String cedulaPropietario, String placaVehiculo) {
		// TODO Auto-generated method stub
		Propietario propietario = this.iPropietarioRepository.seleccionar(cedulaPropietario);
		Vehiculo vehiculo = this.iVehiculoRepository.seleccionar(placaVehiculo);

		Matricula matricula = new Matricula();
		matricula.setNoMatricula("000");
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setValorMatricula(new BigDecimal(000));
		matricula.setPropietario(propietario);
		matricula.setVehiculo(vehiculo);
		this.iMatriculaRepository.actualizar(matricula);

		if (matricula.getVehiculo().getTipo().equals("pesado")) {
			matricula.setValorMatricula(matricula.getVehiculo().getPrecio().multiply(new BigDecimal(0.25)));
			this.iMatriculaRepository.actualizar(matricula);

			if (matricula.getVehiculo().getPrecio().compareTo(new BigDecimal(2200)) == 1) {
				BigDecimal descuento = matricula.getVehiculo().getPrecio().multiply(new BigDecimal(0.05));
				matricula.setValorMatricula(matricula.getVehiculo().getPrecio().subtract(descuento));
			}
			String mensaje = (matricula.getVehiculo().getPrecio().compareTo(new BigDecimal(2200)) == 1)
					? "El vehiculo de tipo PESADO aplica descuento"
					: "el vehiculo PESADO no aplica descuento";
			this.iMatriculaRepository.actualizar(matricula);
			System.out.println(mensaje + matricula);
		} else {
			matricula.setValorMatricula(matricula.getVehiculo().getPrecio().multiply(new BigDecimal(0.20)));
			this.iMatriculaRepository.actualizar(matricula);

			if (matricula.getVehiculo().getPrecio().compareTo(new BigDecimal(2200)) == 1) {
				BigDecimal descuento = matricula.getVehiculo().getPrecio().multiply(new BigDecimal(0.05));
				matricula.setValorMatricula(matricula.getVehiculo().getPrecio().subtract(descuento));
			}
			String mensaje = (matricula.getVehiculo().getPrecio().compareTo(new BigDecimal(2200)) == 1)
					? "El vehiculo de tipo LIVIANO aplica descuento"
					: "el vehiculo LIVIANO no aplica descuento";
			this.iMatriculaRepository.actualizar(matricula);
			System.out.println(mensaje + matricula);
		}
		this.iMatriculaRepository.insertar(matricula);
	}

}
