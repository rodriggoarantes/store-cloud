package com.ras.fornecedor.application;

import java.util.List;

import com.ras.fornecedor.domain.produto.Produto;
import com.ras.fornecedor.domain.produto.ProdutoRepository;
import com.ras.store.infra.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto obter(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Produto nao encontrado"));
	}
	
	public List<Produto> getProdutosPorEstado(String estado) {
		return repository.findByEstado(estado);
	}
}
