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
@Table(name = "tb_categoria")
public class CategoriaEntidade {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull @Size(min= 5, max= 100)
	private String descricao;
	
	@ManyToMany
	private List<ProdutoEntidade> categoriaList;

	//toString 

	@Override
	public String toString() {
		return "CategoriaEntidade [id=" + id + ", descricao=" + descricao + ", categoriaList=" + categoriaList + "]";
	}
	//getters and setters 
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ProdutoEntidade> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<ProdutoEntidade> categoriaList) {
		this.categoriaList = categoriaList;
	}
	
	
	
}
