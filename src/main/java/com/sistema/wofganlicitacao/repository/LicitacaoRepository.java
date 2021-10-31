package com.sistema.wofganlicitacao.repository;

import com.sistema.wofganlicitacao.model.PesquisaPreco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicitacaoRepository extends JpaRepository<PesquisaPreco, Long>{
    
}
