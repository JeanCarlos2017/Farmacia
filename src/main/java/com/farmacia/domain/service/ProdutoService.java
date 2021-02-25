package com.farmacia.domain.service;

import java.util.ArrayList;
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
		ArrayList<ProdutoEntidade> busca= (ArrayList<ProdutoEntidade>) produtoRepositorio.findByNomeContainingIgnoreCase(produto.getNome());
		if (busca.size()> 0) return null; //já existe um produto com esse nome
		else return produtoRepositorio.save(produto);
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
	
	public boolean deleteProduto(long id_produto) {
		if (produtoRepositorio.existsById(id_produto)) {
			//existe um produto com o id passado
			produtoRepositorio.deleteById(id_produto);
			return true;
		}else return false;
	}
	
	public ProdutoRepository getProdutoRepositorio() {
		return produtoRepositorio;
	}

}
