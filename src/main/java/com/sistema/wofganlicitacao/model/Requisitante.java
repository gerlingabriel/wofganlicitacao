package com.sistema.wofganlicitacao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@Entity
public class Requisitante extends Empresa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_requisitante")
    @SequenceGenerator(name="seq_requisitante",
                       sequenceName="seq_requisitante",
                       initialValue = 1,
                       allocationSize=1)
    private Long id;

    @Embedded
    private List<Endereco> endereco;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Licitacao> licitacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public List<Licitacao> getLicitacao() {
        return licitacao;
    }

    public void setLicitacao(List<Licitacao> licitacao) {
        this.licitacao = licitacao;
    }

    

    
}

