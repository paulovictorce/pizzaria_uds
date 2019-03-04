package com.pizzaria.gerenciador.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class PizzaDto implements Serializable {

	private static final long serialVersionUID = 5928065034302218425L;
	
	private Long id;
	
	private String sabor;
	
	public PizzaDto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Pizza [id=" + id + ", sabor=" + sabor + "]";
	}

}
