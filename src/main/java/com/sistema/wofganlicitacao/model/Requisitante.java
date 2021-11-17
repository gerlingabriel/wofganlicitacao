package com.sistema.wofganlicitacao.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Requisitante extends Empresa implements Serializable{

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PesquisaPreco> pesquisaPreco;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContraProposta> contraPropostas;

    public List<PesquisaPreco> getPesquisaPreco() {
        return pesquisaPreco;
    }

    public void setPesquisaPreco(List<PesquisaPreco> pesquisaPreco) {
        this.pesquisaPreco = pesquisaPreco;
    }  
    
}
