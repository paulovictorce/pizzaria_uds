package com.pizzaria.gerenciador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaria.gerenciador.dtos.PeditoDto;
import com.pizzaria.gerenciador.entities.Pedido;
import com.pizzaria.gerenciador.repository.PedidoRepository;

@Service
public class PedidoServices {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> listar() {
		return pedidoRepository.findAll();
	}
	
	public Pedido salvar (PeditoDto peditoDto) {
		Pedido pedido = new Pedido();
		pedido.setSabor(peditoDto.getSabor());
		pedido.setTamanho(peditoDto.getTamanho());
		pedido.setPersonalizacoes(peditoDto.getPersonalizacoes());
		pedido.setTempoPreparo(peditoDto.getTempoPreparo());
		pedido.setValorTotal(peditoDto.getValorTotal());
		
		return pedidoRepository.save(pedido);
	}
	
	public Pedido buscar (Long id) {
		Pedido pedido = pedidoRepository.findOne(id);
		
		if (pedido == null) {
//			throw new PizzaServiceException ("Pizza não cadastrada");
		}
		
		return pedido;
	}
	
}
