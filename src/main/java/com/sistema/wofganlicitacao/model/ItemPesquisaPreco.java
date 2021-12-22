package com.sistema.wofganlicitacao.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemPesquisaPreco implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_item")
    @SequenceGenerator(name="seq_item", sequenceName="seq_item", initialValue = 1, allocationSize=1)
    private Long id;

    @OneToOne
    private Produto produtos;

    @Lob
    private String descricaoProduto;

    private BigDecimal precoUnitario;

    private Short quantidade;

    public ItemPesquisaPreco() {
    }

    public ItemPesquisaPreco(Produto produtos, String descricaoProduto, BigDecimal precoUnitario, Short quantidade) {
        this.produtos = produtos;
        this.descricaoProduto = descricaoProduto;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Short quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
}
