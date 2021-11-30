package com.sistema.wofganlicitacao.validacao.pesquisaPreco;

import com.sistema.wofganlicitacao.security.UserSS;
import com.sistema.wofganlicitacao.service.impl.RequisitanteServiceImpl;
import com.sistema.wofganlicitacao.service.impl.UsuarioLogado;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class PesquisaPrecoValidacao {

    @Autowired
    private RequisitanteServiceImpl requisitanteServiceImpl;

    protected void gerarExcessaoCasoRequisitanteNaoExiste(){

        UserSS usuario = UsuarioLogado.buscarUsuarioLogado();

        requisitanteServiceImpl.verificarSeExisteEmpresaRequisitante(usuario.getId());
    }
    
}
