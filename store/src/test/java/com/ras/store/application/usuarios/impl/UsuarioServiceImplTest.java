package com.ras.store.application.usuarios.impl;

import com.ras.store.application.UsuarioService;
import com.ras.store.domain.usuarios.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class UsuarioServiceImplTest {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    void obter() {
        final Usuario inserted = usuarioService.inserir(Usuario.Builder.instance()
                .login("rra").password("rra").email("rra@rra.com").build());

        final Usuario find = usuarioService.obter(inserted.getId());

        assertThat(find, notNullValue());
        assertThat(find.getId(), notNullValue());
        assertThat(find.getId() > 0, equalTo(true));
        assertThat(find.getId().equals(inserted.getId()), equalTo(true));
    }

    @Test
    void inserir() {
        final Usuario inserted = usuarioService.inserir(Usuario.Builder.instance()
                .login("rra").password("rra").email("rra@rra.com")
                .build());
        assertThat(inserted, notNullValue());
        assertThat(inserted.getId(), notNullValue());
        assertThat(inserted.getId() > 0, equalTo(true));
    }

    @Test
    void alterar() {
    }

    @Test
    void deletar() {
    }

    @Test
    void listar() {
    }
}