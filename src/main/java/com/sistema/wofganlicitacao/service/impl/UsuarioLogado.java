package com.sistema.wofganlicitacao.service.impl;

import com.sistema.wofganlicitacao.security.UserSS;

import org.springframework.security.core.context.SecurityContextHolder;

public class UsuarioLogado {

    private UsuarioLogado() {
        throw new IllegalStateException("Utility class");
      }

    public static UserSS buscarUsuarioLogado(){
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
        
    }
    
}
