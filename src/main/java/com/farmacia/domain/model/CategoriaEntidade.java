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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_categoria")
@Getter @Setter @NoArgsConstructor @ToString
public class CategoriaEntidade {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//@Setter(value= AccessLevel.NONE) apenas para aprendizado :D
	private long id;
	
	@NotNull @Size(min= 5, max= 100)
	private String descricao;
	
	@OneToMany(mappedBy= "categoria", cascade= CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<ProdutoEntidade> produtosList;

}
