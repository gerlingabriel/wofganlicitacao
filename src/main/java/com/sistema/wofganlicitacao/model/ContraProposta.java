package com.sistema.wofganlicitacao.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ContraProposta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_contraProposta")
    @SequenceGenerator(name="seq_contraProposta", sequenceName="seq_contraProposta", initialValue = 1, allocationSize=1)
    private Long id;

    @OneToOne
    private PesquisaPreco pesquisaPreco;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemContraProposta> itens;

    private LocalDate diaEnvio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PesquisaPreco getPesquisaPreco() {
        return pesquisaPreco;
    }

    public void setPesquisaPreco(PesquisaPreco pesquisaPreco) {
        this.pesquisaPreco = pesquisaPreco;
    }

    public List<ItemContraProposta> getItens() {
        return itens;
    }

    public void setItens(List<ItemContraProposta> itens) {
        this.itens = itens;
    }

    public LocalDate getDiaEnvio() {
        return diaEnvio;
    }

    public void setDiaEnvio(LocalDate diaEnvio) {
        this.diaEnvio = diaEnvio;
    }

    
    
}
