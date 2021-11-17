package com.sistema.wofganlicitacao.service;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.login.LoginRecuperarDTO;

public interface RecursoSistemaService {

    void refreshToken(HttpServletResponse response);

    void enviarUmaNovaSenha(@Valid LoginRecuperarDTO loginDTO);
    
}
