package com.example.demorest2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demorest2.entidades.Pessoa;
import com.example.demorest2.repositorios.PessoaRepository;

@SpringBootApplication
public class Demorest2Application implements CommandLineRunner{
	@Autowired
	private PessoaRepository repositorioP;

	public static void main(String[] args) {
		SpringApplication.run(Demorest2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			System.out.println("Inserir uma pessoa no BD: ");
			Pessoa p1 = new Pessoa("Luis", 22);
			repositorioP.inserir(p1);
			
			repositorioP.inserir(new Pessoa("Freeza", 19));
			
		
		
	}

}
