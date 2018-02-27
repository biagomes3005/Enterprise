package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import oracle.jdbc.logging.annotations.Log;
@Entity
@Table(name="TB_BEBIDA")
@SequenceGenerator(name="bebida", sequenceName="SQ_TB_BEBIDA", allocationSize=1)

public class Bebida implements Serializable {
	
	public Bebida() {
		super();
	}
	
	@Id
	@Column(name="CD_BEBIDA")
	@GeneratedValue(generator="bebida", strategy=GenerationType.SEQUENCE)
	private int cdBebida;
	
	@Enumerated(EnumType.STRING)
	@Column(name="DS_TIPO")
	private Tipo tipo;
	
	@Column(name="NM_NOME")
	private String nome;
	
	@Column(name="DT_VALIDADE")
	@Temporal(TemporalType.DATE)
	private Calendar dtValidade;
	
	@Lob
	@Column(name="DS_ROTULO")
	private byte[] rotulo;
	
	@Column(name="ST_ALCOOLICO")
	private boolean alcoolico;

	public Bebida(int cdBebida, Tipo tipo, String nome, Calendar dtValidade, byte[] rotulo, boolean alcoolico) {
		super();
		this.cdBebida = cdBebida;
		this.tipo = tipo;
		this.nome = nome;
		this.dtValidade = dtValidade;
		this.rotulo = rotulo;
		this.alcoolico = alcoolico;
	}


	public int getCdBebida() {
		return cdBebida;
	}


	public void setCdBebida(int cdBebida) {
		this.cdBebida = cdBebida;
	}


	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(Calendar dtValidade) {
		this.dtValidade = dtValidade;
	}

	public byte[] getRotulo() {
		return rotulo;
	}

	public void setRotulo(byte[] rotulo) {
		this.rotulo = rotulo;
	}

	public boolean isAlcoolico() {
		return alcoolico;
	}

	public void setAlcoolico(boolean alcoolico) {
		this.alcoolico = alcoolico;
	}
	
}
