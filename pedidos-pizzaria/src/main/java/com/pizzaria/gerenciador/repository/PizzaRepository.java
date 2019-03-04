package com.pizzaria.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzaria.gerenciador.entities.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

	Pizza findBySabor(String sabor);
}
