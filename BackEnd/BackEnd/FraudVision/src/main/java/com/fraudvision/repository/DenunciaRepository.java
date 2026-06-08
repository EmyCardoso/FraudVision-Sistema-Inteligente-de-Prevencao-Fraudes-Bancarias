package com.fraudvision.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fraudvision.model.Denuncia;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

    List<Denuncia> findByTelefone(String telefone);

}