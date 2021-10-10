package com.sistema.wofganlicitacao.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;



@Entity
public class Fornecedor extends Empresa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_fornecedor")
    @SequenceGenerator(name="seq_fornecedor",
                       sequenceName="seq_fornecedor",
                       initialValue = 1,
                       allocationSize=1)
    private Long id;

    @Embedded
    private List<Endereco> endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
    
    
}
