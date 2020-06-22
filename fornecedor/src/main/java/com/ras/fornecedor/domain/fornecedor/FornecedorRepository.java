package com.ras.fornecedor.domain.fornecedor;

import org.springframework.data.repository.CrudRepository;

public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {
    Fornecedor findFirstByEstadoIgnoreCase(String estado);
}
