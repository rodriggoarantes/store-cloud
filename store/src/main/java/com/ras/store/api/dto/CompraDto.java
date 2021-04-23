package com.ras.store.api.dto;

import java.util.List;

public class CompraDto {

    private Long id;
    private Long loja;
    private EnderecoDto endereco;
    private List<ItemDto> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoja() {
        return loja;
    }

    public void setLoja(Long loja) {
        this.loja = loja;
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public List<ItemDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemDto> itens) {
        this.itens = itens;
    }
}
