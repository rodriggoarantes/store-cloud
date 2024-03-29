package com.ras.fornecedor.application;

import com.ras.fornecedor.domain.fornecedor.Fornecedor;
import com.ras.fornecedor.domain.fornecedor.FornecedorRepository;
import com.ras.store.infra.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

	private static final Logger LOG = LoggerFactory.getLogger(FornecedorService.class);

	@Autowired
	private FornecedorRepository repository;

	public Fornecedor findByEstado(String estado) {
		LOG.info("Fornecedor por Estado: {}", estado);
		return repository.findFirstByEstadoIgnoreCase(estado);
	}

	public Iterable<Fornecedor> listar() {
		return repository.findAll();
	}

	public Fornecedor obter(@NonNull Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Fornecedor nao encontrado"));
	}

	public Fornecedor salvar(@NonNull Fornecedor param) {
		return repository.save(param);
	}
}
