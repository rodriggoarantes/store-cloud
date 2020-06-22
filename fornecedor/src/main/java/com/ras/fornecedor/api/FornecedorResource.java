package com.ras.fornecedor.api;

import com.ras.fornecedor.domain.fornecedor.Fornecedor;
import com.ras.fornecedor.domain.fornecedor.FornecedorRepository;
import com.ras.store.infra.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("suppliers")
public class FornecedorResource {

    @Autowired
    private FornecedorRepository repository;

    @GetMapping
    public Iterable<Fornecedor> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Fornecedor obter(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Fornecedor nao encontrado"));
    }

    @GetMapping("/states/{state}")
    public Fornecedor obterPorEstado(@PathVariable String state) {
        return repository.findFirstByEstadoIgnoreCase(state);
    }

    @PostMapping()
    public Fornecedor save(@RequestBody @NonNull Fornecedor param) {
        return repository.save(param);
    }
}
