package com.pizzaria.gerenciador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaria.gerenciador.dtos.PizzaDto;
import com.pizzaria.gerenciador.entities.Pizza;
import com.pizzaria.gerenciador.repository.PizzaRepository;

@Service
public class PizzaServices {
	@Autowired
	private PizzaRepository pizzaRepository;
	
	public List<Pizza> listar() {
		return pizzaRepository.findAll();
	}
	
	public Pizza salvar (PizzaDto pizzaDto) {
		Pizza pizza = new Pizza();
		pizza.setSabor(pizzaDto.getSabor());
		
		return pizzaRepository.save(pizza);
	}
	
	public Pizza buscar (Long id) {
		Pizza pizza = pizzaRepository.findOne(id);
		
		if (pizza == null) {
//			throw new PizzaServiceException ("Pizza não cadastrada");
		}
		
		return pizza;
	}
	
	

}
