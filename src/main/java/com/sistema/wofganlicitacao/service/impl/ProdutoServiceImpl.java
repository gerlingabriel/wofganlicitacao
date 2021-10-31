package com.sistema.wofganlicitacao.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.produto.ProdutoAtualizarDTO;
import com.sistema.wofganlicitacao.dto.produto.ProdutoCadastroDTO;
import com.sistema.wofganlicitacao.dto.produto.ProdutoRespostaDTO;
import com.sistema.wofganlicitacao.excecao.ExcecaoNoExiste;
import com.sistema.wofganlicitacao.model.Categoria;
import com.sistema.wofganlicitacao.model.Produto;
import com.sistema.wofganlicitacao.repository.CategoriaRepository;
import com.sistema.wofganlicitacao.repository.ProdutoRepository;
import com.sistema.wofganlicitacao.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public ProdutoRespostaDTO create(@Valid ProdutoCadastroDTO cadastrarDTO) {
        Produto produto = new Produto();
        produto.setNome(cadastrarDTO.getNome());

        Categoria categoriaDoProduto = verificarSeExisteCategoria(cadastrarDTO.getIdCategoria());
        produto.setCategoria(categoriaDoProduto);
        
        repository.save(produto);
        return new ProdutoRespostaDTO(produto.getId(), produto.getNome());
    }

    @Override
    public ProdutoRespostaDTO update(@Valid ProdutoAtualizarDTO atualizarDTO) {
        Produto produto  = verificarSeExisteCateroria(atualizarDTO.getId());
        produto.setNome(atualizarDTO.getNome());
        repository.save(produto);
        return new ProdutoRespostaDTO(produto.getId(), produto.getNome());
    }

    @Override
    public List<ProdutoRespostaDTO> findALL() {
       return repository.findAll().stream()
                    .map( x -> new ProdutoRespostaDTO(x.getId(), x.getNome()))
                    .collect(Collectors.toList());
    }

    @Override
    public ProdutoRespostaDTO findById(Long id) {
        Produto produto = verificarSeExisteCateroria(id);
        return new ProdutoRespostaDTO(produto.getId(), produto.getNome());
    }

    /** Métodos privados
     * 
     */
    private Produto verificarSeExisteCateroria(Long id) {
        return repository.findById(id).orElseThrow(() -> new ExcecaoNoExiste("Item não existe"));
    }

    private Categoria verificarSeExisteCategoria(Long idCategoria) {
        return categoriaRepository.findById(idCategoria).orElseThrow(() -> new ExcecaoNoExiste("Categoria não existe"));
    }

    
}
