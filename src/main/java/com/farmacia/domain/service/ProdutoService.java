package com.farmacia.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.domain.model.ProdutoEntidade;
import com.farmacia.domain.respository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepositorio;

	public ProdutoEntidade save(ProdutoEntidade produto) {
		return produtoRepositorio.save(produto);
	}

	public ProdutoEntidade alterProduto(long id_produto, ProdutoEntidade produto) {
		Optional<ProdutoEntidade> buscaProduto = produtoRepositorio.findById(id_produto);
		// verifico se o id é valido
		if (buscaProduto.isEmpty()) {
			return null;
		} else {
			produto.setId(id_produto);
			return produtoRepositorio.save(produto);
		}
	}
	
	public void deleteProduto(long id_produto) {
		produtoRepositorio.deleteById(id_produto);
	}
	
	public ProdutoRepository getProdutoRepositorio() {
		return produtoRepositorio;
	}

}
