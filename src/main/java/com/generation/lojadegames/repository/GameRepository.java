package com.generation.lojadegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.lojadegames.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
