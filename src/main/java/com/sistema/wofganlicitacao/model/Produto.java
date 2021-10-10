package com.sistema.wofganlicitacao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Digits;


@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_produto")
    @SequenceGenerator(name="seq_produto",
                       sequenceName="seq_produto",
                       initialValue = 1,
                       allocationSize=1)
    private Long id;    

    @Column(length = 150)
    private String nome;

    @Column(length = 254)
    private String descricao;

    @Digits(integer = 10, fraction = 2)
    private BigDecimal preco;

    @ManyToOne
    private Categoria categoria;

    @ManyToMany(mappedBy = "produtos")
    private List<Licitacao> licitacoes = new ArrayList<>();

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Licitacao> getLicitacoes() {
        return licitacoes;
    }

    public void setLicitacoes(List<Licitacao> licitacoes) {
        this.licitacoes = licitacoes;
    }

    
    
}
