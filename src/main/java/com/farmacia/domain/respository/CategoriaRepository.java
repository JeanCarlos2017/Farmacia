package com.farmacia.domain.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.domain.model.CategoriaEntidade;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntidade, Long>{
	public CategoriaEntidade findByDescricao(String descricao);
}
