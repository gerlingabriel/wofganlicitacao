package com.sistema.wofganlicitacao.service;

import java.util.List;

import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.fornecedor.FornecedorCadastroDTO;
import com.sistema.wofganlicitacao.dto.fornecedor.FornecedorRequestCompletaDTO;
import com.sistema.wofganlicitacao.dto.fornecedor.FornecedorRespostaCompletaDTO;
import com.sistema.wofganlicitacao.dto.fornecedor.FornecedorRespostaDTO;

public interface FornecedorService {

    List<FornecedorRespostaDTO> buscarTodosFornecedores();

    void cadastrarFornecedor(@Valid FornecedorCadastroDTO cadastroDTO);

    FornecedorRespostaCompletaDTO buscarUmFornecedor(Long id);

    FornecedorRespostaCompletaDTO atualizarUmFornecedor(FornecedorRequestCompletaDTO updateDTO);

    void deletarUmFornecedor(Long id);
    
}
