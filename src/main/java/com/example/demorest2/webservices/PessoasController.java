package com.example.demorest2.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demorest2.entidades.Pessoa;
import com.example.demorest2.repositorios.PessoaRepository;

@RestController
@CrossOrigin
public class PessoasController {
	private PessoaRepository pessoas; //injecao de dependencias a quem eu vou usar o @Autowired
	

// ou crio isso:	
	@Autowired
	public PessoasController(PessoaRepository pessoas) {
		this.pessoas = pessoas;
	}
	
	@PostMapping("/pessoas")
	public ResponseEntity<Void> postPessoas(@RequestBody Pessoa p) {
		pessoas.inserir(p);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@GetMapping("/pessoas")
	public List<Pessoa> getPessoas(){
			return pessoas.findAll();
	}
	
	@GetMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> getPessoas(@PathVariable long id) {
		Pessoa p = pessoas.find(id);
		if(p == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(p);
	}
	
}
