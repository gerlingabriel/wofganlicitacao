package com.sistema.wofganlicitacao.controller;

import java.util.List;

import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.CadastroRequisitanteDTO;
import com.sistema.wofganlicitacao.dto.RequisitanteRespostaDTO;
import com.sistema.wofganlicitacao.service.RequisitanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private RequisitanteService requisitanteService;

    @GetMapping
    public List<RequisitanteRespostaDTO> buscarTodosRequisitantes() {
        return requisitanteService.buscarTodosRequisitantes();
    }

    @PostMapping
    public void cadastroRequisitante(@RequestBody @Valid CadastroRequisitanteDTO cadastroDTO) {
        requisitanteService.cadastrarRequisitante(cadastroDTO);
    }
    
    
}