package com.sistema.wofganlicitacao.repository;

import com.sistema.wofganlicitacao.model.ItemPesquisaPreco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPesquisaPrecoRepository extends JpaRepository<ItemPesquisaPreco, Long>{
    
}
