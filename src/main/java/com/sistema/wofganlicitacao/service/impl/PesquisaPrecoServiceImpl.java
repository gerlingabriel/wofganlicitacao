package com.sistema.wofganlicitacao.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.sistema.wofganlicitacao.dto.item.ItensDTO;
import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoCadastroDTO;
import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoCadastroResponseDTO;
import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoItensResponseDTO;
import com.sistema.wofganlicitacao.dto.pesquisapreco.PesquisaPrecoPesquisaResponseDTO;
import com.sistema.wofganlicitacao.excecao.ExcecaoNoExiste;
import com.sistema.wofganlicitacao.model.ItemPesquisaPreco;
import com.sistema.wofganlicitacao.model.PesquisaPreco;
import com.sistema.wofganlicitacao.model.Produto;
import com.sistema.wofganlicitacao.model.Requisitante;
import com.sistema.wofganlicitacao.repository.PesquisaPrecoRepository;
import com.sistema.wofganlicitacao.security.UserSS;
import com.sistema.wofganlicitacao.service.PesquisaPrecoService;
import com.sistema.wofganlicitacao.validacao.pesquisaPreco.PesquisaPrecoValidarCadastro;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class PesquisaPrecoServiceImpl implements PesquisaPrecoService{

    @Autowired
    private PesquisaPrecoValidarCadastro pesquisaPrecoValidarCadastro;
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private RequisitanteServiceImpl requisitanteServiceImpl;
    @Autowired
    private PesquisaPrecoRepository repository;
    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;

    @Override
    public PesquisaPrecoCadastroResponseDTO create(PesquisaPrecoCadastroDTO cadastrarDTO) {

        pesquisaPrecoValidarCadastro.validarCadastro();

        PesquisaPreco pesquisaPreco = modelMapper.map(cadastrarDTO, PesquisaPreco.class);

        int cont =0;
        for (ItensDTO itensDTO : cadastrarDTO.getItens()) {

            Produto produto = produtoServiceImpl.verificarSeExisteCateroria(itensDTO.getProduto().getId());
            pesquisaPreco.getItens().get(cont).setProdutos(produto);
            pesquisaPreco.getItens().get(cont).setQuantidade(itensDTO.getQuantidade());
            cont++;
        }

        pesquisaPreco.setRequisitante(buscarUsuarioLogado());

        repository.save(pesquisaPreco);

        return modelMapper.map(pesquisaPreco, PesquisaPrecoCadastroResponseDTO.class);
    }

    @Override
    public List<PesquisaPrecoPesquisaResponseDTO> buscarTodasPesquisasPrecoDoRequisitante() {

        List<PesquisaPreco> listaPesquisaPrecsoDoRequisitante = repository.findByRequisitante(buscarUsuarioLogado());

        List<PesquisaPrecoPesquisaResponseDTO> listaPesquisaPrecoDTO = new ArrayList<>(); 

        listaPesquisaPrecsoDoRequisitante.forEach(dado ->  listaPesquisaPrecoDTO.add(modelMapper.map(dado, PesquisaPrecoPesquisaResponseDTO.class) ) );

        return listaPesquisaPrecoDTO;
    }

    @Override
    public List<PesquisaPrecoItensResponseDTO> buscarPesquisaPrecoPorId(Long id) {

        PesquisaPreco pesquisaPreco = verificarSeExistePesquisaPreco(id);

        List<ItemPesquisaPreco> itemPesquisaPreco = pesquisaPreco.getItens();

        return itemPesquisaPreco.stream()
            .map(dado -> modelMapper.map(dado, PesquisaPrecoItensResponseDTO.class) ).collect(Collectors.toList());
    }

    @Override
    public List<PesquisaPrecoCadastroResponseDTO> buscarPesquisaPrecoPorNome(String nome) {

        Requisitante requisitante = buscarUsuarioLogado();

        List<PesquisaPreco> listaPesquisaPreco = repository.findByTituloContainingIgnoreCaseAndRequisitante(nome, requisitante);

        return listaPesquisaPreco.stream()
            .map(dado -> modelMapper.map(dado, PesquisaPrecoCadastroResponseDTO.class)).collect(Collectors.toList());
    }

    /**
     * Metodos Privados
     */
    private Requisitante buscarUsuarioLogado() {

        UserSS buscarUsuarioLogado = UsuarioLogado.buscarUsuarioLogado();

        return requisitanteServiceImpl.verificarSeExisteEmpresaRequisitante(buscarUsuarioLogado.getId());

    }

    private PesquisaPreco verificarSeExistePesquisaPreco(Long id) {
        return repository.findById(id).orElseThrow(() -> new ExcecaoNoExiste("Empresa não existe!"));
    }


    
}
