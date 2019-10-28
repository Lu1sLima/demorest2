package com.example.demorest2.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demorest2.entidades.Pessoa;
@Repository 
@Transactional // vai usar o gerenciador de transacoes banco-objeto do Spring
public class PessoaRepositoryJPA implements PessoaRepository{
	@PersistenceContext
	private EntityManager em;

	@Override
	public void inserir(Pessoa p) { //precisamos passar uma entidade por parametro
		em.persist(p);
	}

	@Override
	public Pessoa inserir(String nome, int idade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa inserir(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> findAll() {
		String jpql = "select p from Pessoa p"; // isso é o nome da classe, nao da tabela
		TypedQuery<Pessoa> consulta = em.createQuery(jpql, Pessoa.class);
		return consulta.getResultList();

	}

	@Override
	public Pessoa find(long id) {
		return em.find(Pessoa.class, id);
	}

	@Override
	public Pessoa remove(long id) {
		Pessoa p = find(id);
		em.remove(p);
		return p;
	}

	@Override
	public void set(Pessoa p) {
		em.merge(p);
	}


}
