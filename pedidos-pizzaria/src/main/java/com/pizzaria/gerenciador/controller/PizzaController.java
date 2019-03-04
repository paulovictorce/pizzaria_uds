package com.pizzaria.gerenciador.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pizzaria.gerenciador.dtos.PizzaDto;
import com.pizzaria.gerenciador.entities.Pizza;
import com.pizzaria.gerenciador.services.PizzaServices;
import com.pizzaria.responses.Response;

@RestController
@RequestMapping("api/pizzas")
public class PizzaController {

	@Autowired
	private PizzaServices pizzaService;
	
	@PostMapping (path = "/new")
	public ResponseEntity<Response<Pizza>> cadastrar (@Valid @RequestBody PizzaDto pizzaDto, BindingResult result) {
		Response<Pizza> response = new Response<Pizza>();
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(response);
		}
		
		Pizza pizzaSalva = this.pizzaService.salvar(pizzaDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pizzaDto.getId())
				.toUri();

		response.setData(pizzaSalva);
		return ResponseEntity.created(location).body(response);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Pizza>> listar() {
		List<Pizza> pizzas = pizzaService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(pizzas);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Pizza>> buscar(@PathVariable("id") Long id) {
  
		Pizza pizza = pizzaService.buscar(id);
		Response<Pizza> response = new Response<Pizza>();
		response.setData(pizza);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
			
}
