package com.ras.store.api;

import com.ras.store.api.dto.CompraDto;
import com.ras.store.application.compras.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchases")
public class CompraResource {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("purchases", HttpStatus.OK);
    }

    @PostMapping()
    public CompraDto order(@RequestBody @NonNull CompraDto compra) {
        return compraService.realizarCompra(compra);
    }
}
