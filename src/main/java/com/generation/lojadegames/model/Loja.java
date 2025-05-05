package com.generation.lojadegames.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_lojadegames")

public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cnpj;
	private String endereco;

	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Game> gamesDisponiveis;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Cliente> clientes;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Venda> vendas;
	
public Loja(Long id, String nome, String cnpj, String endereco,
		List<Game> gamesDisponiveis, List<Cliente> clientes, List<Venda> vendas) {
	
    this.id = id;
    this.nome = nome;
    this.cnpj = cnpj;
    this.endereco = endereco;
    this.gamesDisponiveis = gamesDisponiveis;
    this.clientes = clientes;
    this.vendas = vendas;

	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCnpj() {
	return cnpj;
}

public void setCnpj(String cnpj) {
	this.cnpj = cnpj;
}

public String getEndereco() {
	return endereco;
}

public void setEndereco(String endereco) {
	this.endereco = endereco;
}

public List<Game> getGamesDisponiveis() {
	return gamesDisponiveis;
}

public void setGamesDisponiveis(List<Game> gamesDisponiveis) {
	this.gamesDisponiveis = gamesDisponiveis;
}

public List<Cliente> getClientes() {
	return clientes;
}

public void setClientes(List<Cliente> clientes) {
	this.clientes = clientes;
}

public List<Venda> getVendas() {
	return vendas;
}

public void setVendas(List<Venda> vendas) {
	this.vendas = vendas;
}
	
	
	

}
