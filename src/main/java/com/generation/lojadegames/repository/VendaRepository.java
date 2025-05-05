package com.generation.lojadegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.lojadegames.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	
}