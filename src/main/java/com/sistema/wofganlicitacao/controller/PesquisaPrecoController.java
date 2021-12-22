package com.sistema.wofganlicitacao.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoCadastroDTO;
import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoCadastroResponseDTO;
import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoItensResponseDTO;
import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoPesquisaResponseDTO;
import com.sistema.wofganlicitacao.service.PesquisaPrecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/pesquisaPrecos")
public class PesquisaPrecoController {

    @Autowired
    private PesquisaPrecoService service;

    @PostMapping
    public ResponseEntity<Void> cadastrarPesquisaPreco(@Valid @RequestBody PesquisaPrecoCadastroDTO cadastrarDTO){

        PesquisaPrecoCadastroResponseDTO prequisaPrecoDTO = service.create(cadastrarDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prequisaPrecoDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<PesquisaPrecoPesquisaResponseDTO>> buscarTodasPesquisasPrecoDoRequisitante(){
        return ResponseEntity.ok().body(service.buscarTodasPesquisasPrecoDoRequisitante());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<PesquisaPrecoItensResponseDTO>> buscarPesquisaPrecoPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.buscarPesquisaPrecoPorId(id));
    }

    @GetMapping(value = "pesquisaPorTitulo/{nome}")
    public ResponseEntity<List<PesquisaPrecoCadastroResponseDTO>> buscarPesquisaPrecoPorId(@PathVariable String nome){
        return ResponseEntity.ok().body(service.buscarPesquisaPrecoPorNome(nome));
    }

    
}
