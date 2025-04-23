package com.generation.lojadegames.controller;
	

	import com.generation.lojadegames.model.Produto;
	import com.generation.lojadegames.repository.ProdutoRepository;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;

	@RestController
	@RequestMapping("/produtos")
	public class ProdutoController {

	    @Autowired
	    private ProdutoRepository produtoRepository;

	    @GetMapping
	    public List<Produto> getAll() {
	        return produtoRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Produto> getById(@PathVariable Long id) {
	        return produtoRepository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @GetMapping("/nome/{nome}")
	    public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome) {
	        return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	    }

	    @GetMapping("/plataforma/{plataforma}")
	    public ResponseEntity<List<Produto>> getByPlataforma(@PathVariable String plataforma) {
	        return ResponseEntity.ok(produtoRepository.findAllByPlataforma(plataforma));
	    }

	    @GetMapping("/preco/menor/{valor}")
	    public ResponseEntity<List<Produto>> getByPrecoMenor(@PathVariable Double valor) {
	        return ResponseEntity.ok(produtoRepository.findByPrecoLessThan(valor));
	    }

	    @GetMapping("/preco/maior/{valor}")
	    public ResponseEntity<List<Produto>> getByPrecoMaior(@PathVariable Double valor) {
	        return ResponseEntity.ok(produtoRepository.findByPrecoGreaterThan(valor));
	    }

	    @PostMapping
	    public ResponseEntity<Produto> post(@RequestBody Produto produto) {
	        return ResponseEntity.ok(produtoRepository.save(produto));
	    }

	    @PutMapping
	    public ResponseEntity<Produto> put(@RequestBody Produto produto) {
	        return ResponseEntity.ok(produtoRepository.save(produto));
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        produtoRepository.deleteById(id);
	    }
	}

