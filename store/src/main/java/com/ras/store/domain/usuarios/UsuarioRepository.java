package com.ras.store.domain.usuarios;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findByLogin(String login);
    Usuario findByEmail(String email);
}
