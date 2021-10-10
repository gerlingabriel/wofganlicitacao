package com.sistema.wofganlicitacao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Licitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_licitacao")
    @SequenceGenerator(name="seq_licitacao",
                       sequenceName="seq_licitacao",
                       initialValue = 1,
                       allocationSize=1)
    private Long id;
    
    @Lob
    @Column(length=512)
    private String descricao;

    @ManyToMany
    @JoinTable(name = "LICITACAO_PRODUTO", joinColumns = @JoinColumn(name = "licitacao_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "requisitante_id")
    private Requisitante requisitante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Requisitante getRequisitante() {
        return requisitante;
    }

    public void setRequisitante(Requisitante requisitante) {
        this.requisitante = requisitante;
    }

    
    
}
