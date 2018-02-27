package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.dao.BebidaDAO;
import br.com.fiap.jpa.entity.Bebida;

public class BebidaDAOImpl implements BebidaDAO{
	
	public BebidaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	private EntityManager em;
	private EntityManagerFactory fabrica;
	
	public void abrindoConexao() {
		this.fabrica = Persistence.createEntityManagerFactory("oracle");
		this.em = fabrica.createEntityManager();
	}
	
	public void realizandoTransacao() {
		em.getTransaction().begin();
		em.getTransaction().commit();
	}
	
	
	public void fechandoConexao() {
		em.close();
		fabrica.close();
	}

	@Override
	public Bebida cadastrar(Bebida bebida) {
		abrindoConexao();
		
		em.persist(bebida);
		
		realizandoTransacao();
		fechandoConexao();
		
		return bebida;
	}

	@Override
	public Bebida atualizar(Bebida bebida) {
		abrindoConexao();
		
		bebida.setCdBebida(1);
		em.merge(bebida);
		
		realizandoTransacao();
		fechandoConexao();
		
		return bebida;
	}

	@Override
	public void remover(int codigo) {
		abrindoConexao();
		
		Bebida bebida = buscar(codigo);
		em.remove(bebida);
		
		realizandoTransacao();
		fechandoConexao();
		
	}

	@Override
	public Bebida buscar(int codigo) {
		abrindoConexao();
		Bebida bebida = em.find(Bebida.class, 1);
		
		realizandoTransacao();
		fechandoConexao();
		
		return bebida;
	}
	

}
