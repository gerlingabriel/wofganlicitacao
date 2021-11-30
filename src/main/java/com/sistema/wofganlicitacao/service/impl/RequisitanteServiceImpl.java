package com.sistema.wofganlicitacao.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sistema.wofganlicitacao.dto.requisitante.CadastroRequisitanteDTO;
import com.sistema.wofganlicitacao.dto.requisitante.RequisitanteRequestCompletaDTO;
import com.sistema.wofganlicitacao.dto.requisitante.RequisitanteRespostaCompletaDTO;
import com.sistema.wofganlicitacao.dto.requisitante.RequisitanteRespostaDTO;
import com.sistema.wofganlicitacao.excecao.AutorizacaoNegada;
import com.sistema.wofganlicitacao.excecao.ExcecaoNoExiste;
import com.sistema.wofganlicitacao.model.Requisitante;
import com.sistema.wofganlicitacao.model.enumerado.Perfil;
import com.sistema.wofganlicitacao.repository.RequisitanteRepository;
import com.sistema.wofganlicitacao.security.UserSS;
import com.sistema.wofganlicitacao.service.RequisitanteService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RequisitanteServiceImpl implements RequisitanteService{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RequisitanteRepository repository;
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<RequisitanteRespostaDTO> buscarTodosRequisitantes() {
        return repository.findAll().stream()
                        .map(x -> new RequisitanteRespostaDTO(x.getNomeSocial()) )
                        .collect(Collectors.toList());
    }

    @Override
    public void cadastrarRequisitante(CadastroRequisitanteDTO cadastroDTO) {
        cadastroDTO.setSenha(passwordEncoder.encode(cadastroDTO.getSenha()));

        verificarSeCNPJJafoiAdicionado(cadastroDTO.getCnpj());
        
        Requisitante requisitante = modelMapper.map(cadastroDTO, Requisitante.class);

        requisitante.addPerfil(Perfil.CLIENTE);
        repository.save(requisitante);     
    }

    @Override
    public RequisitanteRespostaCompletaDTO buscarUmaRequisicao(Long id) {

        UserSS usuario = UsuarioLogado.buscarUsuarioLogado();

        if (usuario == null || usuario.seNaoTemPerfilAdm() && !id.equals(usuario.getId())) {
            throw new AutorizacaoNegada("Sem acesso para esse cliente!");
        }

        Requisitante requisitante = verificarSeExisteEmpresaRequisitante(id);
        return modelMapper.map(requisitante, RequisitanteRespostaCompletaDTO.class);
    }

    @Override
    public RequisitanteRespostaCompletaDTO buscarUmaRequisicao(RequisitanteRequestCompletaDTO updateDTO) {
        verificarSeExisteEmpresaRequisitante(updateDTO.getId());

        Requisitante requisitante = modelMapper.map(updateDTO, Requisitante.class);

        repository.save(requisitante);
        return modelMapper.map(requisitante, RequisitanteRespostaCompletaDTO.class);
    }

    @Override
    public void delete(Long id) {
        verificarSeExisteEmpresaRequisitante(id);
        repository.deleteById(id);        
    }

    public Requisitante verificarSeExisteEmpresaRequisitante(Long id) {
        return repository.findById(id).orElseThrow(() -> new ExcecaoNoExiste("Empresa não existe!"));
    }

    public void verificarSeCNPJJafoiAdicionado(String cnpj) {
        Optional<Requisitante> buscaSeCNPJJaFoiAdicionado = repository.findByCnpj(cnpj);
        if(buscaSeCNPJJaFoiAdicionado.isPresent()){
           throw new ExcecaoNoExiste("Cnpj já cadastrado!");
        }
    }

    
    
}
