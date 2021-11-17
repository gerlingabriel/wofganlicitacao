package com.sistema.wofganlicitacao.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ErroAoValidarToken extends RuntimeException{

    public ErroAoValidarToken (String message){
        super(message);
    }
    
}
