package com.sistema.wofganlicitacao.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.sistema.wofganlicitacao.dto.requisitante.CadastroRequisitanteDTO;
import com.sistema.wofganlicitacao.dto.requisitante.RequisitanteRequestCompletaDTO;
import com.sistema.wofganlicitacao.dto.requisitante.RequisitanteRespostaCompletaDTO;
import com.sistema.wofganlicitacao.dto.requisitante.RequisitanteRespostaDTO;
import com.sistema.wofganlicitacao.excecao.ExcecaoNoExiste;
import com.sistema.wofganlicitacao.model.Requisitante;
import com.sistema.wofganlicitacao.repository.RequisitanteRepository;
import com.sistema.wofganlicitacao.service.RequisitanteService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequisitanteServiceImpl implements RequisitanteService{

    @Autowired
    private RequisitanteRepository repository;

    @Override
    public List<RequisitanteRespostaDTO> buscarTodosRequisitantes() {
        return repository.findAll().stream()
                        .map(x -> new RequisitanteRespostaDTO(x.getNomeSocial()) )
                        .collect(Collectors.toList());
    }

    @Override
    public void cadastrarRequisitante(CadastroRequisitanteDTO cadastroDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Requisitante requisitante = modelMapper.map(cadastroDTO, Requisitante.class);

        repository.save(requisitante);     
    }

    @Override
    public RequisitanteRespostaCompletaDTO bsucarUmaRequisicao(Long id) {
        Requisitante requisitante = verificarSeExisteEmpresaRequisitante(id);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(requisitante, RequisitanteRespostaCompletaDTO.class);
    }

    @Override
    public RequisitanteRespostaCompletaDTO bsucarUmaRequisicao(RequisitanteRequestCompletaDTO updateDTO) {
        verificarSeExisteEmpresaRequisitante(updateDTO.getId());
        ModelMapper modelMapper = new ModelMapper();
        Requisitante requisitante = modelMapper.map(updateDTO, Requisitante.class);
        repository.save(requisitante);
        return modelMapper.map(requisitante, RequisitanteRespostaCompletaDTO.class);
    }

    @Override
    public void delete(Long id) {
        verificarSeExisteEmpresaRequisitante(id);
        repository.deleteById(id);        
    }

    /**
     * Métodos Primvados
     */
    private Requisitante verificarSeExisteEmpresaRequisitante(Long id) {
        return repository.findById(id).orElseThrow(() -> new ExcecaoNoExiste("Empresa não existe!"));
    }



    
}
