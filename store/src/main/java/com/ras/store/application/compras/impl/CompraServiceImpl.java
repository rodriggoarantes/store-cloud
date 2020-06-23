package com.ras.store.application.compras.impl;

import com.ras.store.api.dto.CompraDto;
import com.ras.store.api.dto.FornecedorDto;
import com.ras.store.application.compras.CompraService;
import com.ras.store.application.fornecedor.FornecedorService;
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

    private final FornecedorService fornecedorService;

    @Autowired
    public CompraServiceImpl(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @Override
    public void realizarCompra(CompraDto compra) {
        Validate.notNull(compra, "Dados da compra de ver informado");
        Validate.notEmpty(compra.getItens(), "Itens da compra deve ser informado");
        Validate.notNull(compra.getEndereco(), "Endereço da compra é obrigatório");
        Validate.notBlank(compra.getEndereco().getEstado(), "Estado é obrigatório");

        final Optional<FornecedorDto> fornecedorDto = fornecedorService.obterFornecedor(
                compra.getEndereco().getEstado());

        fornecedorDto.orElseThrow(() -> new BusinessException(
                "FOR500", "Nenhum fornecedor encontrado para região", HttpStatus.BAD_REQUEST_400));

        LOG.info("Fornecedor devolvido: {} | {}", fornecedorDto.get().getId(), fornecedorDto.get().getEndereco());
    }
}
