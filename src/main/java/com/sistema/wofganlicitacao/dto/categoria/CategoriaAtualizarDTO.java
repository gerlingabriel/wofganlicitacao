package com.sistema.wofganlicitacao.dto.categoria;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaAtualizarDTO {

    @NotNull(message = "Campo id é obrigatório")
    private Long id;

    @NotEmpty(message = "Campo não pode ser vazio")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    } 
    
}
