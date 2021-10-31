package com.sistema.wofganlicitacao.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.categoria.CategoriaAtualizarDTO;
import com.sistema.wofganlicitacao.dto.categoria.CategoriaCadastroDTO;
import com.sistema.wofganlicitacao.dto.categoria.CategoriaRespostaDTO;
import com.sistema.wofganlicitacao.dto.produto.ProdutoRespostaDTO;
import com.sistema.wofganlicitacao.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public ResponseEntity<CategoriaRespostaDTO> create(@Valid @RequestBody CategoriaCadastroDTO categoriaDTO) {
        CategoriaRespostaDTO categoria = service.create(categoriaDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId())
                .toUri();
        return ResponseEntity.created(location).body(categoria);
    }

    @PutMapping
    public ResponseEntity<CategoriaRespostaDTO> update(@Valid @RequestBody CategoriaAtualizarDTO atualizarDTO) {
        return ResponseEntity.ok().body(service.update(atualizarDTO));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaRespostaDTO>> findAll() {
        return ResponseEntity.ok().body(service.findALL());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaRespostaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping(value = "produtosDaCategoria/{id}")
    public ResponseEntity<List<ProdutoRespostaDTO>> findByType(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findByType(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delte(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
