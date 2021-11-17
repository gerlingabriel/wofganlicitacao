package com.sistema.wofganlicitacao.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.login.LoginRecuperarDTO;
import com.sistema.wofganlicitacao.service.RecursoSistemaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autoricao")
public class RecursosSistema {

    @Autowired
    private RecursoSistemaService recursoSistemaService;

    @PostMapping("/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {

        recursoSistemaService.refreshToken(response);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/recuperarSenha")
    public ResponseEntity<String> recuperarSenha(@Valid @RequestBody LoginRecuperarDTO loginDTO){

        recursoSistemaService.enviarUmaNovaSenha(loginDTO);
        return ResponseEntity.ok().body("Enviado email com sucesso!");
    }
    
}
