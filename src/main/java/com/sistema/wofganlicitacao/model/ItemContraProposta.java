package com.sistema.wofganlicitacao.model;

import javax.persistence.Entity;

@Entity
public class ItemContraProposta extends Item {

    private boolean recusarOferta;

    public boolean isRecusarOferta() {
        return recusarOferta;
    }

    public void setRecusarOferta(boolean recusarOferta) {
        this.recusarOferta = recusarOferta;
    }
    
}
