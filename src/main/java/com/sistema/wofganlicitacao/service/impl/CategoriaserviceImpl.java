package com.sistema.wofganlicitacao.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.categoria.CategoriaAtualizarDTO;
import com.sistema.wofganlicitacao.dto.categoria.CategoriaCadastroDTO;
import com.sistema.wofganlicitacao.dto.categoria.CategoriaRespostaDTO;
import com.sistema.wofganlicitacao.dto.produto.ProdutoRespostaDTO;
import com.sistema.wofganlicitacao.excecao.ExcecaoNoExiste;
import com.sistema.wofganlicitacao.model.Categoria;
import com.sistema.wofganlicitacao.repository.CategoriaRepository;
import com.sistema.wofganlicitacao.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaserviceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository repository;

    @Override
    public CategoriaRespostaDTO create(CategoriaCadastroDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaDTO.getNome());
        repository.save(categoria);
        return new CategoriaRespostaDTO(categoria.getId(), categoria.getNome());
    }

    @Override
    public CategoriaRespostaDTO update(@Valid CategoriaAtualizarDTO atualizarDTO) {
        Categoria categoria  = verificarSeExisteCateroria(atualizarDTO.getId());
        categoria.setNome(atualizarDTO.getNome());
        repository.save(categoria);
        return new CategoriaRespostaDTO(categoria.getId(), categoria.getNome());
    }

    @Override
    public List<CategoriaRespostaDTO> findALL(Pageable pageable) {
       return repository.findAll(pageable).stream()
                    .map( x -> new CategoriaRespostaDTO(x.getId(), x.getNome()))
                    .collect(Collectors.toList());
    }

    @Override
    public CategoriaRespostaDTO findById(Long id) {
        Categoria categoria = verificarSeExisteCateroria(id);
        return new CategoriaRespostaDTO(categoria.getId(), categoria.getNome());
    }

    @Override
    public List<ProdutoRespostaDTO> findByType(Long id) {
        Categoria categoria = verificarSeExisteCateroria(id);
        return categoria.getProdutos().stream().map(x -> new ProdutoRespostaDTO(x.getId(), x.getNome(), x.getCategoria().toString())).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        verificarSeExisteCateroria(id);
        repository.deleteById(id);
    }

    /** Métodos privados
     * 
     */
    private Categoria verificarSeExisteCateroria(Long id) {
        return repository.findById(id).orElseThrow(() -> new ExcecaoNoExiste("Item não existe"));
    }


}
