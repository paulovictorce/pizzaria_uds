package com.pizzaria.gerenciador.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class PeditoDto implements Serializable {

	private static final long serialVersionUID = -3716528500614861382L;
	
	private Long id;
	
	private String tamanho;
	
	private String sabor;
	
	private String personalizacoes;
	
	private double valorTotal;
	
	private String tempoPreparo;
	
	public PeditoDto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	@NotNull(message = "Tamanho não pode ser nulo")
	@NotBlank(message = "Tamanho deve ser selecionado")
	@NotEmpty(message = "Tamanho é uma informação obrigatória")
	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	@NotNull(message = "Sabor não pode ser nulo")
	@NotBlank(message = "Sabor deve ser selecionado")
	@NotEmpty(message = "Sabor é uma informação obrigatória")
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
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", sabor=" + sabor + ", tamanho=" + tamanho + ", extras=" +personalizacoes+""
				+ ", valor="+valorTotal+ ", tempo_preapro=" +tempoPreparo+"]";
	}

}
