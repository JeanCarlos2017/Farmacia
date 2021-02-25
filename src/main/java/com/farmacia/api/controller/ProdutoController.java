package com.farmacia.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.domain.model.ProdutoEntidade;
import com.farmacia.domain.service.ProdutoService;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;

	@GetMapping("")
	public ResponseEntity<List<ProdutoEntidade>> findAll() {
		return ResponseEntity.ok(produtoService.getProdutoRepositorio().findAll());
	}

	@GetMapping("/{id_produto}")
	public ResponseEntity<ProdutoEntidade> findByIdProduto(@PathVariable long id_produto) {
		return produtoService.getProdutoRepositorio().findById(id_produto).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/descricao/{id_produto}")
	public ResponseEntity<ProdutoEntidade> findByDescricaoTitulo(@PathVariable String descricao) {
		return ResponseEntity.ok(produtoService.getProdutoRepositorio().findByDescricaoTitulo(descricao));
	}

	@PostMapping
	public ResponseEntity<ProdutoEntidade> post(@Valid @RequestBody ProdutoEntidade produto){
		ProdutoEntidade prod= produtoService.save(produto);
		return this.valida(prod, HttpStatus.CREATED);
	}

	@PutMapping("/{id_produto}")
	public ResponseEntity<ProdutoEntidade> post(@Valid  @PathVariable long id_produto,
			@RequestBody ProdutoEntidade produto){
		return ResponseEntity.ok(produtoService.alterProduto(id_produto, produto));
	}
	
	@DeleteMapping("/{id_produto}")
	public ResponseEntity<Void> delete(@PathVariable long id_produto) {
		if(produtoService.deleteProduto(id_produto)) return ResponseEntity.noContent().build();
		else return ResponseEntity.notFound().build();
	}
	
	private ResponseEntity<ProdutoEntidade> valida(ProdutoEntidade produto, HttpStatus status){
		if (produto == null) return ResponseEntity.badRequest().build();
		else return ResponseEntity.status(status).body(produto);
	}
}
