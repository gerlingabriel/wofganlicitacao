package com.sistema.wofganlicitacao.service.impl;

import java.util.Optional;

import com.sistema.wofganlicitacao.model.Requisitante;
import com.sistema.wofganlicitacao.repository.RequisitanteRepository;
import com.sistema.wofganlicitacao.security.UserSS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RequisitanteRepository repository;

    @Override
    public UserDetails loadUserByUsername(String cnpj) throws UsernameNotFoundException {

        Optional<Requisitante> findByCnpj = repository.findByCnpj(cnpj);
        if (findByCnpj.isEmpty() )  {
            throw new UsernameNotFoundException("Usuário " +cnpj+ " não existe");
        }
        Requisitante requisitante = findByCnpj.get();
        return new UserSS(requisitante.getId(), requisitante.getCnpj(), requisitante.getSenha(), requisitante.getPerfis() );
    }
    
}
