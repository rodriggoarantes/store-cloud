package com.ras.store.api;

import com.ras.store.domain.lojas.Loja;
import com.ras.store.domain.lojas.LojaRepository;
import com.ras.store.domain.usuarios.Usuario;
import com.ras.store.infra.exception.NotFoundException;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("stores")
public class LojaResource {

    @Autowired
    private LojaRepository repository;

    @GetMapping
    public Iterable<Loja> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Loja obter(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Loja nao encontrada"));
    }

    @PostMapping
    public Loja inserir(@RequestBody Loja param) {
        return repository.save(param);
    }

    @PutMapping
    public Loja alterar(@RequestBody Loja param) {
        Validate.isTrue(Optional.ofNullable(param.getId()).orElse(0L) > 0L,
                "Identificador da loja é obrigatorio");
        return repository.save(param);
    }
}
