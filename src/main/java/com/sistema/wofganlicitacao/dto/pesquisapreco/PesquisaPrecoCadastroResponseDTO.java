package com.sistema.wofganlicitacao.dto.pesquisapreco;

import java.math.BigDecimal;

public class PesquisaPrecoCadastroResponseDTO {

    private Long id;
    private String titulo;
    private String descricaoPesquisaPreco;
    private BigDecimal valorTotal;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricaoPesquisaPreco() {
        return descricaoPesquisaPreco;
    }
    public void setDescricaoPesquisaPreco(String descricaoPesquisaPreco) {
        this.descricaoPesquisaPreco = descricaoPesquisaPreco;
    }
    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
