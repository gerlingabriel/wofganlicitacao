package com.sistema.wofganlicitacao.dto.login;

import java.io.Serializable;

public class LoginDTO implements Serializable{

    private String cnpj;
    private String senha;
    
    public LoginDTO() {
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
}
