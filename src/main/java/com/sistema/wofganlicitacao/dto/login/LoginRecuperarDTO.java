package com.sistema.wofganlicitacao.dto.login;

import javax.validation.constraints.NotEmpty;

public class LoginRecuperarDTO {

    @NotEmpty
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
