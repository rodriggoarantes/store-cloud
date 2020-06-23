package com.ras.store.api.dto;

import java.util.List;

public class PedidoDto {

    private Long id;
    private Long tempoDePreparo;
    private String status;
    private List<ItemDto> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(Long tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemDto> itens) {
        this.itens = itens;
    }
}
