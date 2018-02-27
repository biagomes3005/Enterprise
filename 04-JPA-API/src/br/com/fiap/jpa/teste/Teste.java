package br.com.fiap.jpa.teste;

import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Bebida;
import br.com.fiap.jpa.entity.Tipo;

public class Teste {

	
	public static void main(String[] args) {
		
		EntityManagerFactory bebida = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = bebida.createEntityManager();
		
		Bebida beb = new Bebida(0, Tipo.GUARANA, "JESUS", new GregorianCalendar(2018, Calendar.AUGUST, 5 ), null, false);
		
		em.getTransaction().begin();
		em.persist(beb);
		em.getTransaction().commit();
		
		em.close();
		bebida.close();
		
	}
}
