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

import com.pizzaria.gerenciador.dtos.PeditoDto;
import com.pizzaria.gerenciador.entities.Pedido;
import com.pizzaria.gerenciador.services.PedidoServices;
import com.pizzaria.responses.Response;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {

	@Autowired
	private PedidoServices pedidoService;
	
	@PostMapping (path = "/new")
	public ResponseEntity<Response<Pedido>> cadastrar (@Valid @RequestBody PeditoDto pedidoDto, BindingResult result) {
		Response<Pedido> response = new Response<Pedido>();
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(response);
		}
		
		Pedido pedidoSalvo = this.pedidoService.salvar(pedidoDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedidoDto.getId())
				.toUri();

		response.setData(pedidoSalvo);
		return ResponseEntity.created(location).body(response);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Pedido>> listar() {
		List<Pedido> pedidos = pedidoService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(pedidos);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Pedido>> buscar(@PathVariable("id") Long id) {
  
		Pedido pedido = pedidoService.buscar(id);
		Response<Pedido> response = new Response<Pedido>();
		response.setData(pedido);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
