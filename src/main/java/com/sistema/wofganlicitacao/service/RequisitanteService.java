package com.sistema.wofganlicitacao.service;

import java.util.List;

import com.sistema.wofganlicitacao.dto.requisitante.CadastroRequisitanteDTO;
import com.sistema.wofganlicitacao.dto.requisitante.RequisitanteRequestCompletaDTO;
import com.sistema.wofganlicitacao.dto.requisitante.RequisitanteRespostaCompletaDTO;
import com.sistema.wofganlicitacao.dto.requisitante.RequisitanteRespostaDTO;

public interface RequisitanteService {

    List<RequisitanteRespostaDTO>  buscarTodosRequisitantes();

    void cadastrarRequisitante(CadastroRequisitanteDTO cadastroDTO);

    RequisitanteRespostaCompletaDTO buscarUmaRequisicao(Long id);

    RequisitanteRespostaCompletaDTO buscarUmaRequisicao(RequisitanteRequestCompletaDTO updateDTO);

    void delete(Long id);
    
}