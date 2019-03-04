package com.pizzaria.gerenciador.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "pizza")
public class Pizza implements Serializable {

	private static final long serialVersionUID = 6204918227089608673L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	@Column(name = "sabor", nullable = false)
	private String sabor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	
	public Pizza () {}
	
	public Pizza (Long id, String sabor) {
		this.id = id;
		this.sabor = sabor;
	}
	
	@Override
	public String toString() {
		return "Pizza [id=" + id + ", sabor=" + sabor + "]";
	}

}
