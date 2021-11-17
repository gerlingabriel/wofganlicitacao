package com.sistema.wofganlicitacao.repository;

import java.util.Optional;

import com.sistema.wofganlicitacao.model.Requisitante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisitanteRepository extends JpaRepository<Requisitante, Long>{

    Optional<Requisitante> findByCnpj(String cnpj);
    
}
