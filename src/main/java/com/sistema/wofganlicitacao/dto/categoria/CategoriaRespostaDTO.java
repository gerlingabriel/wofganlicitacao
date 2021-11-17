package com.sistema.wofganlicitacao.dto.categoria;

import java.io.Serializable;

public class CategoriaRespostaDTO implements Serializable{

    private Long id;
    private String nome;
    
    public CategoriaRespostaDTO() {
    }

    public CategoriaRespostaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
