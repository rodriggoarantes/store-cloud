package com.ras.fornecedor.api;

import com.ras.fornecedor.application.FornecedorService;
import com.ras.fornecedor.domain.fornecedor.Fornecedor;
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
    private FornecedorService service;

    @GetMapping
    public Iterable<Fornecedor> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Fornecedor obter(@NonNull @PathVariable Long id) {
        return service.obter(id);
    }

    @GetMapping("/states/{state}")
    public Fornecedor obterPorEstado(@PathVariable String state) {
        return service.findByEstado(state);
    }

    @PostMapping()
    public Fornecedor salvar(@RequestBody @NonNull Fornecedor param) {
        return service.salvar(param);
    }
}
