package com.pizzaria.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaria.gerenciador.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	Pedido findBySabor(String sabor);
}
