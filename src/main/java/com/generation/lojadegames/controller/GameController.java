package com.generation.lojadegames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.generation.lojadegames.model.Game;
import com.generation.lojadegames.repository.GameRepository;

@RestController
@RequestMapping("/games")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public ResponseEntity<List<Game>> getAll() {
        return ResponseEntity.ok(gameRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getById(@PathVariable Long id) {
        return gameRepository.findById(id)
                .map(game -> ResponseEntity.ok(game))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Game> post(@RequestBody Game game) {
        return ResponseEntity.ok(gameRepository.save(game));
    }

    @PutMapping
    public ResponseEntity<Game> put(@RequestBody Game game) {
        return ResponseEntity.ok(gameRepository.save(game));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gameRepository.deleteById(id);
    }
}
