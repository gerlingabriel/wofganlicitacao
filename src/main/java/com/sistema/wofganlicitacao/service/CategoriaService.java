package com.sistema.wofganlicitacao.service;

import java.util.List;

import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.categoria.CategoriaAtualizarDTO;
import com.sistema.wofganlicitacao.dto.categoria.CategoriaCadastroDTO;
import com.sistema.wofganlicitacao.dto.categoria.CategoriaRespostaDTO;
import com.sistema.wofganlicitacao.dto.produto.ProdutoRespostaDTO;

public interface CategoriaService {

    CategoriaRespostaDTO create(CategoriaCadastroDTO categoriaDTO);

    CategoriaRespostaDTO update(@Valid CategoriaAtualizarDTO atualizarDTO);

    List<CategoriaRespostaDTO> findALL();

    CategoriaRespostaDTO findById(Long id);

    List<ProdutoRespostaDTO> findByType(Long id);

    void delete(Long id);


    
}
