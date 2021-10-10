package com.sistema.wofganlicitacao.repository;

import com.sistema.wofganlicitacao.model.Fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
    
}
