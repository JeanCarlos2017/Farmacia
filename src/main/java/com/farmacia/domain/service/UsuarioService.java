package com.farmacia.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.domain.model.UsuarioEntidade;
import com.farmacia.domain.respository.UsuarioRepositorio;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public UsuarioEntidade post(UsuarioEntidade usuario) {
		UsuarioEntidade busca= usuarioRepositorio.findByNome(usuario.getNome());
		if(busca != null) return null; //já existe um usuário com esse nome
		else return usuarioRepositorio.save(usuario);
	}

	public UsuarioEntidade put(long id_usuario, UsuarioEntidade usuario) {
		Optional<UsuarioEntidade> busca= usuarioRepositorio.findById(id_usuario);
		if(busca.isEmpty()) return null; //o id passado nao existe
		else {
			usuario.setId_usuario(id_usuario);
			return usuarioRepositorio.save(usuario);
		}
	}

	public boolean delete(long id_usuario) {
		Optional<UsuarioEntidade> busca= usuarioRepositorio.findById(id_usuario);
		if(busca.isEmpty()) return false; //o id passado nao existe
		else {
			usuarioRepositorio.deleteById(id_usuario);
			return true;
		}
	}

	public UsuarioRepositorio getUsuarioRepositorio() {
		return usuarioRepositorio;
	}
	
	
}
