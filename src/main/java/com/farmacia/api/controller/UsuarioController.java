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

import com.farmacia.domain.model.UsuarioEntidade;
import com.farmacia.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioEntidade>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getUsuarioRepositorio().findAll());
	}
	
	@GetMapping("/{id_usuario}")
	public ResponseEntity<UsuarioEntidade> findById(@PathVariable Long id_usuario) {
		return usuarioService.getUsuarioRepositorio().findById(id_usuario)
						.map(resp -> ResponseEntity.ok(resp))
						.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<UsuarioEntidade> findByNome(@PathVariable String nome) {
		UsuarioEntidade user= usuarioService.getUsuarioRepositorio().findByNome(nome);
		return this.validaUsuario(user);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioEntidade> post(@Valid @RequestBody UsuarioEntidade usuario) {
		UsuarioEntidade user= usuarioService.post(usuario);
		if(user == null) return ResponseEntity.badRequest().build();
		else return ResponseEntity.ok(user);
	}
	@PutMapping("/{id_usuario}")
	public ResponseEntity<UsuarioEntidade> put(@Valid @PathVariable long id_usuario,
											 @RequestBody UsuarioEntidade usuario) {
		UsuarioEntidade user= usuarioService.put(id_usuario, usuario);
		return this.validaUsuario(user);
	}
	
	@DeleteMapping("/{id_usuario}")
	public ResponseEntity<Void> delete(@PathVariable long id_usuario) {
		boolean deletou= usuarioService.delete(id_usuario);
		if(!deletou) return ResponseEntity.notFound().build();
		else return ResponseEntity.noContent().build();
	}
	
	private ResponseEntity<UsuarioEntidade> validaUsuario(UsuarioEntidade user){
		if(user == null) return ResponseEntity.notFound().build();
		else return ResponseEntity.ok(user);
	}
	
}
