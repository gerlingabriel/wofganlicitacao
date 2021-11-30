package com.sistema.wofganlicitacao.validacao.pesquisaPreco;

import org.springframework.stereotype.Service;

@Service
public class PesquisaPrecoValidarCadastro extends PesquisaPrecoValidacao {

    public void validarCadastro(){
        super.gerarExcessaoCasoRequisitanteNaoExiste();
    }
    
}
