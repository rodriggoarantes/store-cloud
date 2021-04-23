package com.ras.store.application.usuarios.impl;

import com.ras.store.application.UsuarioService;
import com.ras.store.domain.usuarios.Usuario;
import com.ras.store.domain.usuarios.UsuarioRepository;
import com.ras.store.infra.exception.NotFoundException;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }

    @Override
    public Usuario obter(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Usuário não encontrado com ID %s", id)));
    }

    @Override
    public Usuario inserir(Usuario usuario) {
        validade(usuario);
        Validate.notNull(usuario.getPassword(), "Dados do usuário incompleto Password");
        return repository.save(usuario);
    }

    @Override
    public Usuario alterar(Usuario usuario) {
        validade(usuario);
        Validate.notNull(usuario.getId(), "Dados do usuário incompleto");
        return repository.save(usuario);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Usuario> listar() {
        return Optional.of(repository.findAll()).map(it -> {
            final List<Usuario> result = new ArrayList<>();
            it.forEach(result::add);
            return result;
        }).orElse(Collections.emptyList());
    }

    private static void validade(Usuario usuario) {
        Validate.notNull(usuario, "Dados do usuário não informado");
        Validate.notNull(usuario.getLogin(), "Dados do usuário incompleto Login");
        Validate.notNull(usuario.getEmail(), "Dados do usuário incompleto Login");
    }
}
