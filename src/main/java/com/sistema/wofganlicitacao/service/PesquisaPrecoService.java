package com.sistema.wofganlicitacao.service;

import java.util.List;

import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoCadastroDTO;
import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoCadastroResponseDTO;
import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoItensResponseDTO;
import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoPesquisaResponseDTO;

public interface PesquisaPrecoService {

    PesquisaPrecoCadastroResponseDTO create(PesquisaPrecoCadastroDTO cadastrarDTO);

    List<PesquisaPrecoPesquisaResponseDTO> buscarTodasPesquisasPrecoDoRequisitante();

    List<PesquisaPrecoItensResponseDTO> buscarPesquisaPrecoPorId(Long id);

    List<PesquisaPrecoCadastroResponseDTO> buscarPesquisaPrecoPorNome(String nome);
    
}
