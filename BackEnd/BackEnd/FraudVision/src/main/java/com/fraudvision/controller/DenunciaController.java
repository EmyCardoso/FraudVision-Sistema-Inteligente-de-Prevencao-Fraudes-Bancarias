package com.fraudvision.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fraudvision.model.Denuncia;
import com.fraudvision.service.DenunciaService;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    private final DenunciaService service;

    public DenunciaController(DenunciaService service) {
        this.service = service;
    }

    @PostMapping
    public Denuncia salvar(@RequestBody Denuncia denuncia) {
        return service.salvar(denuncia);
    }

    @GetMapping
    public List<Denuncia> listar() {
        return service.listar();
    }

    @GetMapping("/telefone/{telefone}")
    public List<Denuncia> buscarPorTelefone(
            @PathVariable String telefone) {

        return service.buscarPorTelefone(telefone);
    }
}