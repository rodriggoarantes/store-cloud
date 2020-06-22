package com.ras.store.domain.lojas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loja")
public class Loja {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome = "";

    public Loja() {}

    public Loja(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
