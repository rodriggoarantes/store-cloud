package com.ras.store.application.compras.impl;

import com.ras.store.api.dto.CompraDto;
import com.ras.store.api.dto.FornecedorDto;
import com.ras.store.api.dto.PedidoDto;
import com.ras.store.application.compras.CompraService;
import com.ras.store.application.fornecedor.FornecedorClient;
import com.ras.store.infra.exception.BusinessException;
import org.apache.commons.lang3.Validate;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraServiceImpl.class);

    private final FornecedorClient fornecedorClient;

    @Autowired
    public CompraServiceImpl(FornecedorClient fornecedorClient) {
        this.fornecedorClient = fornecedorClient;
    }

    @Override
    public CompraDto realizarCompra(CompraDto compra) {
        Validate.notNull(compra, "Dados da compra de ver informado");
        Validate.notEmpty(compra.getItens(), "Itens da compra deve ser informado");
        Validate.notNull(compra.getEndereco(), "Endereço da compra é obrigatório");
        Validate.notBlank(compra.getEndereco().getEstado(), "Estado é obrigatório");

        LOG.info("Buscando fornecedor: {}", compra.getEndereco().getEstado());
        final Optional<FornecedorDto> fornecedorDto = Optional.ofNullable(fornecedorClient.obterPorEstado(
                compra.getEndereco().getEstado()));

        fornecedorDto.orElseThrow(() -> new BusinessException(
                "FOR500", "Nenhum fornecedor encontrado para região", HttpStatus.BAD_REQUEST_400));

        LOG.info("Gerando pedido com fornecedor: {}", fornecedorDto.get().getId());
        final PedidoDto pedido = fornecedorClient.realizarPedido(compra.getItens());

        LOG.info("Fornecedor devolvido: {} | {}", fornecedorDto.get().getId(), fornecedorDto.get().getEndereco());
        LOG.info("Pedido Realizado: {} | {}", pedido.getId(), pedido.getTempoDePreparo());

        final CompraDto pedidoCompra = new CompraDto();
        pedidoCompra.setId(pedido.getId());
        pedidoCompra.setEndereco(compra.getEndereco());
        pedidoCompra.setItens(pedido.getItens());
        pedidoCompra.setLoja(1L);

        return pedidoCompra;
    }
}
