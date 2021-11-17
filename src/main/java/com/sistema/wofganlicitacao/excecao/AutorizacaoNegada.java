package com.sistema.wofganlicitacao.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
public class AutorizacaoNegada extends RuntimeException{

    public AutorizacaoNegada (String message){
        super(message);
    }
    
}
