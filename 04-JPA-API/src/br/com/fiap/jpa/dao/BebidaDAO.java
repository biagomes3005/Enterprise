package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Bebida;

public interface BebidaDAO {
	
	Bebida cadastrar(Bebida bebida);
	Bebida atualizar(Bebida bebida);
	void remover(int codigo);
	Bebida buscar(int codigo);
	
	
}
