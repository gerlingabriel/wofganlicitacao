package com.sistema.wofganlicitacao.dto.categoria;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class CategoriaCadastroDTO implements Serializable{

    @NotEmpty(message = "Campo não pode ser vazio")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    } 
    
}
