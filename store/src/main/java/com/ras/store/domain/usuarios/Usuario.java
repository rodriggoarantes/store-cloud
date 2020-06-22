package com.ras.store.domain.usuarios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String login = "";

    @Column(nullable = false)
    private String email = "";

    private String foto = "";

    @Transient
    private String password = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static class Builder {
        private final Usuario user;

        private Builder() {
            this.user = new Usuario();
        }

        public static Builder instance() {
            return new Builder();
        }

        public Builder id(Long param) {
            user.setId(param);
            return this;
        }

        public Builder login(String param) {
            user.setLogin(param);
            return this;
        }

        public Builder password(String param) {
            user.setPassword(param);
            return this;
        }

        public Builder email(String param) {
            user.setEmail(param);
            return this;
        }

        public Builder foto(String param) {
            user.setFoto(param);
            return this;
        }

        public Usuario build() {
            return this.user;
        }
    }
}
