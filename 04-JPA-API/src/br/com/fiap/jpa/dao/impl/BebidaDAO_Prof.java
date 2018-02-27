package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.dao.BebidaDAO;
import br.com.fiap.jpa.entity.Bebida;

public class BebidaDAO_Prof implements BebidaDAO{
	public BebidaDAO_Prof(EntityManager em) {
		super();
		this.em = em;
	}
	
	private EntityManager em;
	private EntityManagerFactory fabrica;
	
	@Override
	public Bebida cadastrar(Bebida bebida) {
		em.persist(bebida);
		em.getTransaction().begin();
		em.getTransaction().commit();
		return bebida;
	}

	@Override
	public Bebida atualizar(Bebida bebida) {
		em.merge(bebida);
		em.getTransaction().begin();
		em.getTransaction().commit();
		return bebida;
	}

	@Override
	public void remover(int codigo) {
		Bebida bebida = buscar(codigo);
		em.remove(bebida);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
	}

	@Override
	public Bebida buscar(int codigo) {
		return em.find(Bebida.class, 1);
	}
	
	
}

