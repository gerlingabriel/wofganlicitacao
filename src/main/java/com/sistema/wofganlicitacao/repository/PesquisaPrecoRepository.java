package com.sistema.wofganlicitacao.repository;

import java.util.List;

import com.sistema.wofganlicitacao.model.PesquisaPreco;
import com.sistema.wofganlicitacao.model.Requisitante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesquisaPrecoRepository extends JpaRepository<PesquisaPreco, Long> {

    List<PesquisaPreco> findByRequisitante(Requisitante buscarUsuarioLogado);

    List<PesquisaPreco> findByTituloContainingIgnoreCaseAndRequisitante(String nome, Requisitante requisitante);
    
}
