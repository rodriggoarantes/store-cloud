package com.ras.fornecedor.api;

import com.ras.fornecedor.api.dto.ItemDoPedidoDto;
import com.ras.fornecedor.application.PedidoService;
import com.ras.fornecedor.domain.pedido.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDto> itens) {
		return pedidoService.realizaPedido(itens);
	}
	
	@RequestMapping("/{id}")
	public Pedido obter(@PathVariable Long id) {
		return pedidoService.obter(id);
	}
}
