package com.sistema.wofganlicitacao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Requisitante extends Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_requisitante")
    @SequenceGenerator(name = "seq_requisitante", sequenceName = "seq_requisitante", initialValue = 1, allocationSize = 1)
    private Long id;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PesquisaPreco> pesquisaPreco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PesquisaPreco> getPesquisaPreco() {
        return pesquisaPreco;
    }

    public void setPesquisaPreco(List<PesquisaPreco> pesquisaPreco) {
        this.pesquisaPreco = pesquisaPreco;
    }  
    
}
