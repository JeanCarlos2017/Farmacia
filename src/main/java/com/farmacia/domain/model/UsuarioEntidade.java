package com.farmacia.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class UsuarioEntidade {
	@NotNull
	private String nome;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;

	@OneToMany(mappedBy= "usuario", cascade= CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<ProdutoEntidade> carrinhoProdutos;

	@Override
	public String toString() {
		return "UsuarioEntidade [nome=" + nome + ", id_usuario=" + id_usuario + ", carrinhoProdutos=" + carrinhoProdutos
				+ "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public List<ProdutoEntidade> getCarrinhoProdutos() {
		return carrinhoProdutos;
	}

	public void setCarrinhoProdutos(List<ProdutoEntidade> carrinhoProdutos) {
		this.carrinhoProdutos = carrinhoProdutos;
	}

	
	

}
