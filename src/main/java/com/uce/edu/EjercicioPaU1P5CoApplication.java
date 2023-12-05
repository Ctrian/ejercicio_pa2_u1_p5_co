package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.service.IMatriculaService;
import com.uce.edu.service.IPropietarioService;
import com.uce.edu.service.IVehiculoService;

@SpringBootApplication
public class EjercicioPaU1P5CoApplication implements CommandLineRunner {

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IPropietarioService iPropietarioService;

	@Autowired
	private IMatriculaService iMatriculaService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU1P5CoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Vehiculo vehiculo1 = new Vehiculo();
		vehiculo1.setMarca("Mercedes");
		vehiculo1.setPlaca("ert");
		vehiculo1.setPrecio(new BigDecimal(5000));
		vehiculo1.setTipo("liviano");
		this.iVehiculoService.guardar(vehiculo1);

		Propietario propietario1 = new Propietario();
		propietario1.setApellido("Oli");
		propietario1.setCedula("147");
		propietario1.setGenero("Masculino");
		propietario1.setNombre("Cristian");
		this.iPropietarioService.guardar(propietario1);

		Matricula matricula = new Matricula();

		matricula = this.iMatriculaService.buscar("000");

		System.out.println(matricula);

		this.iMatriculaService.matricular("147", "ert");

		matricula = this.iMatriculaService.buscar("000");

		System.out.println(matricula);
	}

}
