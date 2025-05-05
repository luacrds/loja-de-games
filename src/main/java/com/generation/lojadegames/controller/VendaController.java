package com.generation.lojadegames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.generation.lojadegames.model.Venda;
import com.generation.lojadegames.repository.VendaRepository;

import java.util.List;

@RestController
@RequestMapping("/venda")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping
    public ResponseEntity<List<Venda>> getAll() {
        return ResponseEntity.ok(vendaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> getById(@PathVariable Long id) {
        return vendaRepository.findById(id)
                .map(venda -> ResponseEntity.ok(venda))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Venda> create(@RequestBody Venda venda) {
        return ResponseEntity.status(201).body(vendaRepository.save(venda));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> update(@PathVariable Long id, @RequestBody Venda venda) {
        return vendaRepository.findById(id)
                .map(existingVenda -> {
                    existingVenda.setDataVenda(venda.getDataVenda());
                    existingVenda.setGames(venda.getGames());
                    existingVenda.setCliente(venda.getCliente());
                    return ResponseEntity.ok(vendaRepository.save(existingVenda));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (vendaRepository.existsById(id)) {
            vendaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
