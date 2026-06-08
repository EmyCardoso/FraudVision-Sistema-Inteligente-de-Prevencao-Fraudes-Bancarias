package com.fraudvision.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fraudvision.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
