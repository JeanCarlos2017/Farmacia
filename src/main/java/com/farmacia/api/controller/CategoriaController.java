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
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.domain.model.CategoriaEntidade;
import com.farmacia.domain.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("")
	public ResponseEntity<List<CategoriaEntidade>> findAllCategoria() {
		return ResponseEntity.ok(categoriaService.getCategoriaRepositorio().findAll());
	}

	@GetMapping("/{id_categoria}")
	public ResponseEntity<CategoriaEntidade> findByIdCategoria(@PathVariable long id_categoria) {
		return categoriaService.getCategoriaRepositorio().findById(id_categoria).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<CategoriaEntidade> findByCategoria(@PathVariable String descricao) {
		return ResponseEntity.ok(categoriaService.getCategoriaRepositorio().findByDescricao(descricao));
	}

	@PostMapping
	public ResponseEntity<CategoriaEntidade> post(@Valid @RequestBody CategoriaEntidade categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
	}

	@PutMapping("/{id_categoria}")
	public ResponseEntity<CategoriaEntidade> put(@Valid @PathVariable long id_categoria,
			@RequestBody CategoriaEntidade categoriaEntidade) {
		return ResponseEntity.status(HttpStatus.OK).
				body(categoriaService.alter(categoriaEntidade, id_categoria));
	}
	
	@DeleteMapping
	public void delete(@Valid @RequestBody CategoriaEntidade categoria) {
		categoriaService.delete(categoria);
	}
}
