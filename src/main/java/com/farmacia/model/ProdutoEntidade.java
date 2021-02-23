package com.farmacia.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class ProdutoEntidade {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull @Size(min= 5, max= 100)
	private String descricaoTitulo;
	
	@NotNull @Size(min= 5, max= 20)
	private String nome;
	
	@ManyToMany
	private List<CategoriaEntidade> categoriaList;
	//toString
	@Override
	public String toString() {
		return "ProdutoEntidade [id=" + id + ", descricaoTitulo=" + descricaoTitulo + ", nome=" + nome
				+ ", categoriaList=" + categoriaList + "]";
	}
	
	//getters and setters 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricaoTitulo() {
		return descricaoTitulo;
	}
	public void setDescricaoTitulo(String descricaoTitulo) {
		this.descricaoTitulo = descricaoTitulo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<CategoriaEntidade> getCategoriaList() {
		return categoriaList;
	}
	public void setCategoriaList(List<CategoriaEntidade> categoriaList) {
		this.categoriaList = categoriaList;
	}
	
	
}
