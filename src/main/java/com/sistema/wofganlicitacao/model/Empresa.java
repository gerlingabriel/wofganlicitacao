package com.sistema.wofganlicitacao.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import com.sistema.wofganlicitacao.model.enumerado.Perfil;

@MappedSuperclass
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_empresa")
    @SequenceGenerator(name = "seq_empresa", sequenceName = "seq_empresa", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(length = 15, nullable = false, unique = true)
    private String cnpj;

    @Column(length = 100, nullable = false )
    private String nomeSocial;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = true)
    private String token;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS", joinColumns = {
        @JoinColumn(name = "id", referencedColumnName= "id")
       })
    private Set<Integer> perfis = new HashSet<>();

    @Column(length = 50, nullable = true)
    private String email;

    @Embedded
    private Endereco enderecos;   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPerfis(Set<Integer> perfis) {
        this.perfis = perfis;
    }

    public Set<Perfil> getPerfis() {
        return perfis
                .stream()
                .map(Perfil::toEnum)
                .collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil){
        perfis.add(perfil.getCod());
    }

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