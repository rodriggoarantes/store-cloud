package com.ras.fornecedor.api;

import java.util.List;

import com.ras.fornecedor.application.ProdutoService;
import com.ras.fornecedor.domain.produto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/{id}")
	public Produto obter(@PathVariable("id") Long id) {
		return produtoService.obter(id);
	}
	
	@GetMapping("/states/{state}")
	public List<Produto> listarPorEstado(@PathVariable("state") String estado) {
		return produtoService.getProdutosPorEstado(estado);
	}
}
