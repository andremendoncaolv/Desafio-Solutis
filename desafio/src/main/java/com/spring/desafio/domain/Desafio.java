package com.spring.desafio.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Desafio implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String palavra;
	private char vogal;
	private Double tempoTotal;
	private boolean palavraValida;
	
	public Desafio() {
	}

	public Desafio(Integer id, String palavra, char vogal) {
		super();
		this.id = id;
		this.palavra = palavra;
		this.vogal = vogal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public char getVogal() {
		return vogal;
	}

	public void setVogal(char vogal) {
		this.vogal = vogal;
	}

	public Double getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(Double tempoTotal) {
		this.tempoTotal = tempoTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Desafio other = (Desafio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean isPalavraValida() {
		return palavraValida;
	}

	public void setPalavraValida(boolean palavraValida) {
		this.palavraValida = palavraValida;
	}
	
}
