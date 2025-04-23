package com.generation.lojadegames.model;
import jakarta.persistence.*;

@Entity
public class Produto {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nome;
	    private Double preco;

	    @ManyToOne
	    @JoinColumn(name = "categoria_id")
	    private Categoria categoria;


	}



