package com.sistema.wofganlicitacao.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class PesquisaPreco implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_licitacao")
    @SequenceGenerator(name="seq_licitacao", sequenceName="seq_licitacao", initialValue = 1, allocationSize=1)
    private Long id;

    @Column
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "requisitante_id")
    private Requisitante requisitante;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "item_pesquisa_preco_id", nullable = false)
    private List<ItemPesquisaPreco> itens;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Requisitante getRequisitante() {
        return requisitante;
    }

    public void setRequisitante(Requisitante requisitante) {
        this.requisitante = requisitante;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<ItemPesquisaPreco> getItens() {
        return itens;
    }

    public void setItens(List<ItemPesquisaPreco> itens) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PesquisaPreco other = (PesquisaPreco) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
