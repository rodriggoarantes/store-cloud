package com.ras.store.api;

import com.ras.store.application.UsuarioService;
import com.ras.store.domain.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Usuario obter(@PathVariable Long id) {
        return service.obter(id);
    }

    @PostMapping
    public Usuario inserir(@RequestBody Usuario usuario) {
        return service.inserir(usuario);
    }

    @PutMapping
    public Usuario alterar(@RequestBody Usuario usuario) {
        return service.alterar(usuario);
    }
}
