package com.sistema.wofganlicitacao.model.enumerado;

public enum Perfil {

    ADMIN(1, "ROLE_ADMIN"),
    CLIENTE(2, "ROLE_CLIENTE");

    private Perfil(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    private int cod;
    private String descricao;

    public static Perfil toEnum(Integer cod){
        
        for(Perfil x: Perfil.values()){
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inváldio :" +cod);
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
