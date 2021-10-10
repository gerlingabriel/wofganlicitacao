package com.sistema.wofganlicitacao.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.sistema.wofganlicitacao.dto.CadastroRequisitanteDTO;
import com.sistema.wofganlicitacao.dto.RequisitanteRespostaDTO;
import com.sistema.wofganlicitacao.model.Requisitante;
import com.sistema.wofganlicitacao.repository.RequisitanteRepository;
import com.sistema.wofganlicitacao.service.RequisitanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequisitanteServiceImpl implements RequisitanteService{

    @Autowired
    private RequisitanteRepository repository;

    @Override
    public List<RequisitanteRespostaDTO> buscarTodosRequisitantes() {
        return repository.findAll().stream()
                        .map(x -> new RequisitanteRespostaDTO(x.getNomeSocial()))
                        .collect(Collectors.toList());
    }

    @Override
    public void cadastrarRequisitante(CadastroRequisitanteDTO cadastroDTO) {

        
    }


    
}
