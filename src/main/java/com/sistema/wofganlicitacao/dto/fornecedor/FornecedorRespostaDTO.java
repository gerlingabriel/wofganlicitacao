package com.sistema.wofganlicitacao.dto.fornecedor;

import java.io.Serializable;

public class FornecedorRespostaDTO implements Serializable{

    private String nomeSocial;

    public FornecedorRespostaDTO() {
    }

    public FornecedorRespostaDTO(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }
    
}
    

