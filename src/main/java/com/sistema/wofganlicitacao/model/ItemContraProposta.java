package com.sistema.wofganlicitacao.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class ItemContraProposta extends ItemPesquisaPreco {

    private boolean recusarOferta;

    public ItemContraProposta(Produto produtos, String descricaoProduto, BigDecimal precoUnitario, Short quantidade) {
        super(produtos, descricaoProduto, precoUnitario, quantidade);
    }

    public boolean isRecusarOferta() {
        return recusarOferta;
    }

    public void setRecusarOferta(boolean recusarOferta) {
        this.recusarOferta = recusarOferta;
    }
    
}
