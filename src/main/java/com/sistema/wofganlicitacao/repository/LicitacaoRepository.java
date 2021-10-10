package com.sistema.wofganlicitacao.repository;

import com.sistema.wofganlicitacao.model.Licitacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicitacaoRepository extends JpaRepository<Licitacao, Long>{
    
}
