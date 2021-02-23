package com.farmacia.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.domain.model.CategoriaEntidade;
import com.farmacia.domain.respository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepositorio;
	
	public CategoriaEntidade save(CategoriaEntidade categoria) {
		return categoriaRepositorio.save(categoria);
	}
	
	public CategoriaEntidade alter(CategoriaEntidade categoria, long id_categoria) {
		Optional<CategoriaEntidade> buscaCategoria= categoriaRepositorio.findById(id_categoria);
		if(buscaCategoria.isEmpty()) {
			return null;
		}else {
			categoria.setId(id_categoria);
			return categoriaRepositorio.save(categoria);
		}
	}
	
	public void delete(long id_categoria) {
		categoriaRepositorio.deleteById(id_categoria);
	}

	public CategoriaRepository getCategoriaRepositorio() {
		return categoriaRepositorio;
	}

	
	
}
