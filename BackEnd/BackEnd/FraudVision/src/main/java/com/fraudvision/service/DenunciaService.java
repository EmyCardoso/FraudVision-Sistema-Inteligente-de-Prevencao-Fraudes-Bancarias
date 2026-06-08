package com.fraudvision.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fraudvision.model.Denuncia;
import com.fraudvision.repository.DenunciaRepository;

@Service
public class DenunciaService {

    private final DenunciaRepository repository;

    public DenunciaService(DenunciaRepository repository) {
        this.repository = repository;
    }

    public Denuncia salvar(Denuncia denuncia) {

        int score = 0;

        String texto = denuncia.getDescricao().toLowerCase();

        // Regras da IA simulada
        if (texto.contains("pix")) score += 30;
        if (texto.contains("senha")) score += 30;
        if (texto.contains("urgente")) score += 20;
        if (texto.contains("clique")) score += 20;
        if (texto.contains("bloqueada")) score += 20;
        if (texto.contains("banco")) score += 20;
        if (texto.contains("conta")) score += 20;
        if (texto.contains("transferencia")) score += 20;
        if (texto.contains("agendado")) score += 25;
        if (texto.contains("cancelar")) score += 15;
        if (texto.contains("link")) score += 20;
        if (texto.contains("dados")) score += 15;
        if (texto.contains("confirmar")) score += 15;
        if (texto.contains("transacao")) score += 20;
        if (texto.contains("whatsapp")) score += 20;
        if (texto.contains("cartao")) score += 20;
        if (texto.contains("emprestimo")) score += 20;
        if (texto.contains("codigo")) score += 15;

        // Limita o score a 100
        if (score > 100) {
            score = 100;
        }

        denuncia.setScore(score);

        if (score >= 70) {
            denuncia.setRisco("ALTO");
        } else if (score >= 40) {
            denuncia.setRisco("MEDIO");
        } else {
            denuncia.setRisco("BAIXO");
        }

        return repository.save(denuncia);
    }

    public List<Denuncia> listar() {
        return repository.findAll();
    }

    public List<Denuncia> buscarPorTelefone(String telefone) {
        return repository.findByTelefone(telefone);
    }
}