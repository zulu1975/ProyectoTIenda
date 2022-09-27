package com.MisionTic.ProyectoTienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProyectoTiendaApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoTiendaApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		String pass1="user";
		String pass2="admin";

		System.out.println(passEncoder.encode(pass1));
		System.out.println(passEncoder.encode(pass2));
	}
}
