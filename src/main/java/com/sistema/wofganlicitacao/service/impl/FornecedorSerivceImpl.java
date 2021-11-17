package com.sistema.wofganlicitacao.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.sistema.wofganlicitacao.dto.fornecedor.FornecedorCadastroDTO;
import com.sistema.wofganlicitacao.dto.fornecedor.FornecedorRequestCompletaDTO;
import com.sistema.wofganlicitacao.dto.fornecedor.FornecedorRespostaCompletaDTO;
import com.sistema.wofganlicitacao.dto.fornecedor.FornecedorRespostaDTO;
import com.sistema.wofganlicitacao.excecao.ExcecaoNoExiste;
import com.sistema.wofganlicitacao.model.Fornecedor;
import com.sistema.wofganlicitacao.repository.FornecedorRepository;
import com.sistema.wofganlicitacao.service.FornecedorService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FornecedorSerivceImpl implements FornecedorService{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<FornecedorRespostaDTO> buscarTodosFornecedores() {
        return repository.findAll().stream()
                    .map(x -> new FornecedorRespostaDTO(x.getNomeSocial()) )
                    .collect(Collectors.toList());
    }

    @Override
    public void cadastrarFornecedor(FornecedorCadastroDTO cadastroDTO) {
        cadastroDTO.setSenha(passwordEncoder.encode(cadastroDTO.getSenha()));

        Fornecedor fornecedor = modelMapper.map(cadastroDTO, Fornecedor.class);

        repository.save(fornecedor);     
    }

    @Override
    public FornecedorRespostaCompletaDTO buscarUmFornecedor(Long id) {
        Fornecedor fornecedor = verificarSeExisteEmpresaFornecedor(id);
        return modelMapper.map(fornecedor, FornecedorRespostaCompletaDTO.class);
    }

    @Override
    public FornecedorRespostaCompletaDTO atualizarUmFornecedor(FornecedorRequestCompletaDTO updateDTO) {
        verificarSeExisteEmpresaFornecedor(updateDTO.getId());

        Fornecedor fornecedor = modelMapper.map(updateDTO, Fornecedor.class);

        repository.save(fornecedor);
        return modelMapper.map(fornecedor, FornecedorRespostaCompletaDTO.class);
    }

    @Override
    public void deletarUmFornecedor(Long id) {
        verificarSeExisteEmpresaFornecedor(id);
        repository.deleteById(id);        
    }

    /**
     * Métodos Primvados
     */
    private Fornecedor verificarSeExisteEmpresaFornecedor(Long id) {
        return repository.findById(id).orElseThrow(() -> new ExcecaoNoExiste("Empresa não existe!"));
    }

}
