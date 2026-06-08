package com.fraudvision.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fraudvision.model.Usuario;
import com.fraudvision.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioRepository repository;

	public UsuarioController(UsuarioRepository repository) {

		this.repository = repository;

	}

	@PostMapping

	public Usuario salvar(@RequestBody Usuario usuario) {

		return repository.save(usuario);

	}

	@GetMapping

	public List<Usuario> listar() {

		return repository.findAll();
	}
}