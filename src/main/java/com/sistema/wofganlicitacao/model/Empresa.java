package com.sistema.wofganlicitacao.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Empresa {

    @Column(length = 15, nullable = false, unique = true)
    private String cnpj;

    @Column(length = 100, nullable = false )
    private String nomeSocial;

    @Column(length = 15, nullable = false)
    private String senha;

    @Column(nullable = true)
    private String token;

    @Column(length = 50, nullable = true)
    private String email;

    @Embedded
    private Endereco enderecos;


    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco enderecos) {
        this.enderecos = enderecos;
    }

    
}