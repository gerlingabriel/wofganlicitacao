package com.sistema.wofganlicitacao.controller;

import java.util.List;

import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.requisitante.CadastroRequisitanteDTO;
import com.sistema.wofganlicitacao.dto.requisitante.RequisitanteRequestCompletaDTO;
import com.sistema.wofganlicitacao.dto.requisitante.RequisitanteRespostaCompletaDTO;
import com.sistema.wofganlicitacao.dto.requisitante.RequisitanteRespostaDTO;
import com.sistema.wofganlicitacao.service.RequisitanteService;

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
@RequestMapping("/empresas")
public class RequisitanteController {

    @Autowired
    private RequisitanteService service;

    @GetMapping
    public List<RequisitanteRespostaDTO> buscarTodosRequisitantes() {
        return service.buscarTodosRequisitantes();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public void cadastroRequisitante(@RequestBody @Valid CadastroRequisitanteDTO cadastroDTO) {
        service.cadastrarRequisitante(cadastroDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RequisitanteRespostaCompletaDTO> buscarCampoCompleto(@PathVariable Long id){
        return ResponseEntity.ok().body(service.buscarUmaRequisicao(id));
    }

    @PutMapping
    public ResponseEntity<RequisitanteRespostaCompletaDTO> update(@RequestBody RequisitanteRequestCompletaDTO updateDTO){
        return ResponseEntity.ok().body(service.buscarUmaRequisicao(updateDTO));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
}