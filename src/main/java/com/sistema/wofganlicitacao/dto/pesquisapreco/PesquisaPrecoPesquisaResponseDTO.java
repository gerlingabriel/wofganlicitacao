package com.sistema.wofganlicitacao.dto.pesquisapreco;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PesquisaPrecoPesquisaResponseDTO {

    private Long id;
    private String titulo;
    private String descricaoPesquisaPreco;
    private BigDecimal valorTotal;

    private LocalDate dataInicio;
    private LocalDate dataFim;

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
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    
}
