package com.sistema.wofganlicitacao.dto.pesquisapreco;

import java.time.LocalDate;
import java.util.List;

import com.sistema.wofganlicitacao.model.Item;
import com.sistema.wofganlicitacao.model.Requisitante;

public class PesquisaPrecoCadastroDTO {

    private String titulo;

    private String descricao;

    private Requisitante requisitante;

    private List<Item> itens;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Requisitante getRequisitante() {
        return requisitante;
    }

    public void setRequisitante(Requisitante requisitante) {
        this.requisitante = requisitante;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
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
