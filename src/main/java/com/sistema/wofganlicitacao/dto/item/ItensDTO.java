package com.sistema.wofganlicitacao.dto.item;

import java.math.BigDecimal;

import com.sistema.wofganlicitacao.dto.produto.ProdutoRequestDTO;

public class ItensDTO {

    private ProdutoRequestDTO produto;

    private String descricaoProduto;

    private BigDecimal precoUnitario;

    private Short quantidade;

    public ProdutoRequestDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoRequestDTO produto) {
        this.produto = produto;
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
