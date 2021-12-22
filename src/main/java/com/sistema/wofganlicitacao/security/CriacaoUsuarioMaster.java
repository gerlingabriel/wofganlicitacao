package com.sistema.wofganlicitacao.security;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.sistema.wofganlicitacao.model.Categoria;
import com.sistema.wofganlicitacao.model.ItemPesquisaPreco;
import com.sistema.wofganlicitacao.model.PesquisaPreco;
import com.sistema.wofganlicitacao.model.Produto;
import com.sistema.wofganlicitacao.model.Requisitante;
import com.sistema.wofganlicitacao.model.enumerado.Perfil;
import com.sistema.wofganlicitacao.repository.CategoriaRepository;
import com.sistema.wofganlicitacao.repository.PesquisaPrecoRepository;
import com.sistema.wofganlicitacao.repository.ProdutoRepository;
import com.sistema.wofganlicitacao.repository.RequisitanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CriacaoUsuarioMaster implements CommandLineRunner{

    @Autowired
    private RequisitanteRepository requisitanteRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PesquisaPrecoRepository pesquisaPrecoRepository;

    @Override
    public void run(String... args) throws Exception {
        
        if (requisitanteRepository.findByCnpj("11111111111111").isEmpty()) {

            Requisitante requisitante = new Requisitante();
            requisitante.setEmail("gerlin.gabriel@gmail.com");
            requisitante.setCnpj("11111111111111");
            requisitante.setSenha(new BCryptPasswordEncoder().encode("123"));
            requisitante.setNomeSocial("Registro Master");
            requisitante.addPerfil(Perfil.CLIENTE);
            requisitante.addPerfil(Perfil.ADMIN);

            requisitanteRepository.save(requisitante);

            Categoria categoriaInformatica = new Categoria("Informaáfica");
            categoriaRepository.save(categoriaInformatica);

            Produto produtoNotebook = new Produto("Notebook");
            produtoNotebook.setCategoria(categoriaInformatica);
            produtoRepository.save(produtoNotebook);

            PesquisaPreco pesquisaPreco = new PesquisaPreco() ;
            pesquisaPreco.setRequisitante(requisitante);    
            
            pesquisaPreco.setTitulo("Orçamento dos materiais de escritório do FINDES");
            ItemPesquisaPreco itemPesquisaPreco = new ItemPesquisaPreco(produtoNotebook, "Notebook 8gb, 512 SSD e I5", BigDecimal.valueOf(4800.50), (short)3);
            ItemPesquisaPreco itemPesquisaPreco2 = new ItemPesquisaPreco(produtoNotebook, "Notebook 16gb, 1T SSD e I7", BigDecimal.valueOf(4800.50), (short)3);
            pesquisaPreco.setItens(List.of(itemPesquisaPreco, itemPesquisaPreco2));

            pesquisaPreco.setDataInicio(LocalDate.of(2021, 12, 01));
            pesquisaPreco.setDataFim(LocalDate.of(2022, 02, 05));

            /** Outra pesquisa preco */
            PesquisaPreco pesquisaPreco2 = new PesquisaPreco() ;
            pesquisaPreco2.setRequisitante(requisitante);    
            
            pesquisaPreco2.setTitulo("Orçamento dos materiais paraPrefeitura de Vitória");
            ItemPesquisaPreco itemPesquisaPreco1 = new ItemPesquisaPreco(produtoNotebook, "Notebook 8gb, 512 SSD e I5", BigDecimal.valueOf(4800.50), (short)3);
            ItemPesquisaPreco itemPesquisaPreco11 = new ItemPesquisaPreco(produtoNotebook, "Notebook 16gb, 1T SSD e I7", BigDecimal.valueOf(4800.50), (short)3);
            pesquisaPreco2.setItens(List.of(itemPesquisaPreco1, itemPesquisaPreco11));

            pesquisaPreco2.setDataInicio(LocalDate.of(2021, 12, 01));
            pesquisaPreco2.setDataFim(LocalDate.of(2022, 02, 05));

            pesquisaPrecoRepository.saveAll(List.of(pesquisaPreco, pesquisaPreco2));
        }
    }    
}

