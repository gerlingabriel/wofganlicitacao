package com.sistema.wofganlicitacao.controller;

import java.util.List;

import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.fornecedor.FornecedorCadastroDTO;
import com.sistema.wofganlicitacao.dto.fornecedor.FornecedorRequestCompletaDTO;
import com.sistema.wofganlicitacao.dto.fornecedor.FornecedorRespostaCompletaDTO;
import com.sistema.wofganlicitacao.dto.fornecedor.FornecedorRespostaDTO;
import com.sistema.wofganlicitacao.service.FornecedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<FornecedorRespostaDTO>> buscarTodosFornecedores() {
        return ResponseEntity.ok().body(service.buscarTodosFornecedores() );
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public void cadastroRequisitante(@RequestBody @Valid FornecedorCadastroDTO cadastroDTO) {
        service.cadastrarFornecedor(cadastroDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FornecedorRespostaCompletaDTO> buscarUmFornecedor(@PathVariable Long id){
        return ResponseEntity.ok().body(service.buscarUmFornecedor(id));
    }

    @PutMapping
    public ResponseEntity<FornecedorRespostaCompletaDTO> atualizarUmFornecedor(@RequestBody FornecedorRequestCompletaDTO updateDTO){
        return ResponseEntity.ok().body(service.atualizarUmFornecedor(updateDTO));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletarUmFornecedor(id);
        return ResponseEntity.noContent().build();
    }
    
    
}