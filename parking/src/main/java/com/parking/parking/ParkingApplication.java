package com.parking.parking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.parking.parking.modelo.Usuarios;
import com.parking.parking.negocio.repository.UsuariosRepository;
import com.parking.parking.negocio.services.UsuriosService;

@SpringBootApplication
public class ParkingApplication implements CommandLineRunner {
	
	@Autowired
	private UsuariosRepository usuriosService;
	
	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
	}

	
	@Override
    public void run(String[] args) {
//		usuriosService.save(new Usuarios(3, "hollaaa", "sdfsdf"));
		List<Usuarios> usuarios = usuriosService.findAll();
		System.out.println("HOLAAA< "+usuarios.size());
	}
}
