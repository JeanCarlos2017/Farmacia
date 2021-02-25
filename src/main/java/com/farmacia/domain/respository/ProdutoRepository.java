package com.farmacia.domain.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.domain.model.ProdutoEntidade;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntidade, Long>{
	public ProdutoEntidade findByDescricaoTitulo(String titulo);
	public List<ProdutoEntidade> findByNomeContainingIgnoreCase(String nome);

}
