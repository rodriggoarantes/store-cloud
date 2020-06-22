package com.ras.store.api.dto;

import java.util.List;

public class CompraDto {

    private Long loja;
    private List<ItemDto> itens;
    private EnderecoDto endereco;

    public Long getLoja() {
        return loja;
    }

    public void setLoja(Long loja) {
        this.loja = loja;
    }

    public List<ItemDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemDto> itens) {
        this.itens = itens;
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }
}
