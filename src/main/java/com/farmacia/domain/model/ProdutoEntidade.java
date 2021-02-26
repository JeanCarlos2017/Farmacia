package com.farmacia.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_produto")
@Getter @Setter @NoArgsConstructor @ToString
public class ProdutoEntidade {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull @Size(min= 5, max= 100)
	private String descricaoTitulo;
	
	@NotNull @Size(min= 5, max= 20)
	private String nome;
	
	@ManyToOne
	@JsonIgnoreProperties("produtosList")
	private CategoriaEntidade categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("carrinhoProdutos")
	private UsuarioEntidade usuario;
	
		
}
