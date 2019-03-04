package com.pizzaria.gerenciador.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "tamanho", nullable = false)
	private String tamanho;
	
	@Column(name = "sabor", nullable = false)
	private String sabor;
	
	@Column(name = "personalizacao", nullable = true)
	private String personalizacoes;
	
	@Column(name = "valor_total", nullable = true)
	private double valorTotal;
	
	@Column(name = "tempo_preparo", nullable = true)
	private String tempoPreparo;
	
	
	
	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getPersonalizacoes() {
		return personalizacoes;
	}

	public void setPersonalizacoes(String personalizacoes) {
		this.personalizacoes = personalizacoes;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(String tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public Pedido() {}
	
	public Pedido (Long id, String tamanho, String sabor, String personalizacoes, 
			Double valorTotal, String tempoPreparo) {
		this.id = id;
		this.tamanho = tamanho;
		this.sabor = sabor;
		this.personalizacoes = personalizacoes;
		this.valorTotal = valorTotal;
		this.tempoPreparo = tempoPreparo;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", sabor=" + sabor + ", tamanho=" + tamanho + ", extras=" +personalizacoes+""
				+ ", valor="+valorTotal+ ", tempo_preapro=" +tempoPreparo+"]";
	}
}
