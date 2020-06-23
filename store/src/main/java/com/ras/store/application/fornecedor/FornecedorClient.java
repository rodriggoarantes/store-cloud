package com.ras.store.application.fornecedor;

import com.ras.store.api.dto.FornecedorDto;
import com.ras.store.api.dto.ItemDto;
import com.ras.store.api.dto.PedidoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("fornecedor")
@RequestMapping("/api")
public interface FornecedorClient {

    @GetMapping("/suppliers/states/{estado}")
    FornecedorDto obterPorEstado(@NonNull @PathVariable String estado);

    @PostMapping("/orders")
    PedidoDto realizarPedido(@NonNull List<ItemDto> itens);
}
