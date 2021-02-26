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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_usuario")
@Getter @Setter @NoArgsConstructor @ToString
public class UsuarioEntidade {
	@NotNull
	private String nome;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;

	@OneToMany(mappedBy= "usuario", cascade= CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<ProdutoEntidade> carrinhoProdutos;

	
}
