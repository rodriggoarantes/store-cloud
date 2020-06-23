package com.ras.fornecedor.application;

import com.ras.fornecedor.api.dto.ItemDoPedidoDto;
import com.ras.fornecedor.domain.pedido.Pedido;
import com.ras.fornecedor.domain.pedido.PedidoItem;
import com.ras.fornecedor.domain.pedido.PedidoRepository;
import com.ras.fornecedor.domain.produto.Produto;
import com.ras.fornecedor.domain.produto.ProdutoRepository;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
	private static final Logger LOG = LoggerFactory.getLogger(PedidoService.class);
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public Pedido realizaPedido(@NonNull List<ItemDoPedidoDto> itens) {
		Validate.notNull(itens, "Lista de itens é obrigatória");
		LOG.info("Gerando pedido ao fornecedor itens: {}", itens.size());

		final List<PedidoItem> pedidoItens = toPedidoItem(itens);
		final Pedido pedido = new Pedido(pedidoItens);
		pedido.setTempoDePreparo(itens.size());
		return pedidoRepository.save(pedido);
	}
	
	public Pedido obter(Long id) {
		return this.pedidoRepository.findById(id).orElse(new Pedido());
	}

	private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDto> itens) {
		
		final List<Long> idsProdutos = itens
				.stream()
				.map(ItemDoPedidoDto::getId)
				.collect(Collectors.toList());
		
		final List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);

		return itens
			.stream()
			.map(item -> {
				final Produto produto = produtosDoPedido
						.stream()
						.filter(p -> p.getId() == item.getId())
						.findFirst().get();

				final PedidoItem pedidoItem = new PedidoItem();
				pedidoItem.setProduto(produto);
				pedidoItem.setQuantidade(item.getQuantidade());
				return pedidoItem;
			})
			.collect(Collectors.toList());
	}
}
