package com.sistema.wofganlicitacao.repository;

import java.util.List;

import com.sistema.wofganlicitacao.model.Produto;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    List<Produto> findByNomeIgnoreCaseContaining(String nome, Pageable pageable);
    
}
