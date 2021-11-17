package com.sistema.wofganlicitacao.controller;

import java.net.URI;

import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoCadastroDTO;
import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoCadastroResponseDTO;
import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoPesquisaResponseDTO;
import com.sistema.wofganlicitacao.service.PesquisaPrecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping
public class PesquisaPrecoController {

    @Autowired
    private PesquisaPrecoService service;

    @PostMapping
    public ResponseEntity<PesquisaPrecoCadastroResponseDTO> cadastrarPesquisaPreco(@Valid @RequestBody PesquisaPrecoCadastroDTO cadastrarDTO){
        PesquisaPrecoCadastroResponseDTO prequisaPrecoDTO = service.create(cadastrarDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prequisaPrecoDTO.getId())
                .toUri();
        return ResponseEntity.created(location).body(prequisaPrecoDTO);
    }

    @GetMapping
    public ResponseEntity<PesquisaPrecoPesquisaResponseDTO> buscarTodasPesquisasPrecoDoRequisitante(){
        return null;
    }
    
}
