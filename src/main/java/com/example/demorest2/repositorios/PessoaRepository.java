package com.example.demorest2.repositorios;

import java.util.List;

import com.example.demorest2.entidades.Pessoa;

public interface PessoaRepository {
	void inserir(Pessoa p);
	Pessoa inserir(String nome, int idade);
	Pessoa inserir(String nome);
	List<Pessoa> findAll(); // o entity manager que diz se vai ser ArrayList ou linked
	Pessoa find(long id);
	Pessoa remove(long id);
	void set(Pessoa p);
	
}
