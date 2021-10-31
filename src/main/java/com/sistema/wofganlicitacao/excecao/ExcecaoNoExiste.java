package com.sistema.wofganlicitacao.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExcecaoNoExiste extends RuntimeException{

    public ExcecaoNoExiste (String message){
        super(message);
    }
    
}
