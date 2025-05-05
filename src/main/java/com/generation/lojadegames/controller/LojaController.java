package com.generation.lojadegames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.generation.lojadegames.model.Loja;
import com.generation.lojadegames.repository.LojaRepository;

@RestController
@RequestMapping ("/loja")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class LojaController {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@GetMapping
	public ResponseEntity<List<Loja>> getAll(){
		return ResponseEntity.ok(lojaRepository.findAll());
		
	}
	

}
