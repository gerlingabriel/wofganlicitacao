package com.sistema.wofganlicitacao.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Item implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_item")
    @SequenceGenerator(name="seq_item", sequenceName="seq_item", initialValue = 1, allocationSize=1)
    private Long id;

    @OneToOne
    private Produto produtos;

    private BigDecimal precoUnitario;

    private BigDecimal precoTotal;

    private Short quantidade;

    public BigDecimal getSubPedido(){
        return precoTotal.multiply(BigDecimal.valueOf(quantidade)).setScale(2);
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

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Short quantidade) {
        this.quantidade = quantidade;
    }

    
    
}
