package com.sistema.wofganlicitacao.service;

import java.util.List;

import com.sistema.wofganlicitacao.dto.CadastroRequisitanteDTO;
import com.sistema.wofganlicitacao.dto.RequisitanteRespostaDTO;

public interface RequisitanteService {

    List<RequisitanteRespostaDTO>  buscarTodosRequisitantes();

    void cadastrarRequisitante(CadastroRequisitanteDTO cadastroDTO);
    
}