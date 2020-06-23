package com.ras.store.application.fornecedor;

import com.ras.store.api.dto.FornecedorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("fornecedor")
@RequestMapping("/api/suppliers")
public interface FornecedorClient {

    @GetMapping("/states/{estado}")
    FornecedorDto obterPorEstado(@NonNull @PathVariable String estado);
}
