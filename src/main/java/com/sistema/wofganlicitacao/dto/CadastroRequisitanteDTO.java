package com.sistema.wofganlicitacao.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

public class CadastroRequisitanteDTO {

    @NotBlank(message = "Nome não deve ser vazio ou em branco")
    private String nomeSocial;

    @CNPJ(message = "CNPJ inválido!")
    @NotBlank(message = "Nome não deve ser vazio ou em branco")
    private String cnpj;

    @NotBlank(message = "Senha deve conter no máximo 15 caracteres")
    private String senha;

    private String token;

    @Email(message = "Email inválido!")
    @NotBlank(message = "Email não deve ser vazio ou em branco")
    private String email;

    private EnderecoDTO enderecoDTO;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnderecoDTO getEnderecoDTO() {
        return enderecoDTO;
    }

    public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
        this.enderecoDTO = enderecoDTO;
    }

    
    
}
