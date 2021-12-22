package com.sistema.wofganlicitacao.dto.pesquisapreco;

import java.math.BigDecimal;

import com.sistema.wofganlicitacao.dto.produto.ProdutoDTO;

public class PesquisaPrecoItensResponseDTO {

    private ProdutoDTO produtos;
    private String descricaoProduto;
    private BigDecimal precoUnitario;
    private Short quantidade;

    public ProdutoDTO getProdutos() {
        return produtos;
    }

    public void setProdutos(ProdutoDTO produtos) {
        this.produtos = produtos;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
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
    
    
}
