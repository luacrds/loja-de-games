package com.generation.lojadegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.lojadegames.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
