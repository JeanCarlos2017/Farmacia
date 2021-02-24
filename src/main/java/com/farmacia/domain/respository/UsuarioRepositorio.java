package com.farmacia.domain.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.domain.model.UsuarioEntidade;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidade, Long>{

	public UsuarioEntidade findByNome(String nome);

}
