package com.sistema.wofganlicitacao.repository;

import com.sistema.wofganlicitacao.model.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
