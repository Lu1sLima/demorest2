package com.example.demorest2.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pessoas")//nomeei o objeto pessoas para tabela pessoas
public class Pessoa {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private long id;
	@Column(length = 50, nullable = false)
	private String nome;
	// decidi que idade é opcional
	private int idade;
	
	
	public Pessoa() {
		
	}
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public Pessoa(String nome, int idade, long id) {
		this.nome = nome;
		this.idade = idade;
		this.id = id;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String toString() {
		return "Nome: "+getNome()+"\n"+
				"Idade: "+getIdade()+"\n"+
				"Id: "+getId();
		
	}
	

}
