package com.sistema.wofganlicitacao.dto.categoria;

import javax.validation.constraints.NotEmpty;

public class CategoriaCadastroDTO {

    @NotEmpty(message = "Campo não pode ser vazio")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    } 
    
}
