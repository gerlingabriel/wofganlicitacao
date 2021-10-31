package com.sistema.wofganlicitacao.service;

import java.util.List;

import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.produto.ProdutoAtualizarDTO;
import com.sistema.wofganlicitacao.dto.produto.ProdutoCadastroDTO;
import com.sistema.wofganlicitacao.dto.produto.ProdutoRespostaDTO;

public interface ProdutoService {

    ProdutoRespostaDTO create(@Valid ProdutoCadastroDTO cadastrarDTO);

    ProdutoRespostaDTO update(@Valid ProdutoAtualizarDTO atualizarDTO);

    List<ProdutoRespostaDTO> findALL();

    ProdutoRespostaDTO findById(Long id);
    
}