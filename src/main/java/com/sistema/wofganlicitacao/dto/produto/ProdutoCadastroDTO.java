package com.sistema.wofganlicitacao.dto.produto;

import javax.validation.constraints.NotEmpty;

public class ProdutoCadastroDTO {

    @NotEmpty(message = "Campo não pode ser vazio")
    private String nome;

    private Long idCategoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
    
}
