package com.sistema.wofganlicitacao.service;

import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoCadastroDTO;
import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoCadastroResponseDTO;

public interface PesquisaPrecoService {

    PesquisaPrecoCadastroResponseDTO create(PesquisaPrecoCadastroDTO cadastrarDTO);
    
}
