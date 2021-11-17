package com.sistema.wofganlicitacao.dto.requisitante;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CadastroRequisitanteDTO {

    @NotBlank(message = "Nome não deve ser vazio ou em branco")
    private String nomeSocial;

    @NotBlank(message = "Nome não deve ser vazio ou em branco")
    private String cnpj;

    @NotBlank(message = "Senha deve conter no máximo 15 caracteres")
    private String senha;

    @Email(message = "Email inválido!")
    @NotBlank(message = "Email não deve ser vazio ou em branco")
    private String email;


    private EnderecoDTO enderecos;

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnderecoDTO getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(EnderecoDTO enderecos) {
        this.enderecos = enderecos;
    }
    
}
