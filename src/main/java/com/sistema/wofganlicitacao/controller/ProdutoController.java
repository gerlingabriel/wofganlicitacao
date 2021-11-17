package com.sistema.wofganlicitacao.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.produto.ProdutoAtualizarDTO;
import com.sistema.wofganlicitacao.dto.produto.ProdutoCadastroDTO;
import com.sistema.wofganlicitacao.dto.produto.ProdutoRespostaDTO;
import com.sistema.wofganlicitacao.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoRespostaDTO> create(@Valid @RequestBody ProdutoCadastroDTO cadastrarDTO) {
        ProdutoRespostaDTO produto = service.create(cadastrarDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId())
                .toUri();
        return ResponseEntity.created(location).body(produto);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping
    public ResponseEntity<ProdutoRespostaDTO> update(@Valid @RequestBody ProdutoAtualizarDTO atualizarDTO) {
        return ResponseEntity.ok().body(service.update(atualizarDTO));
    }

    @GetMapping
    @CachePut(value = "produtos")
    public ResponseEntity<List<ProdutoRespostaDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findALL(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoRespostaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
