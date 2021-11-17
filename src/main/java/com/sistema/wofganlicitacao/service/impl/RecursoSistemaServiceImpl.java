package com.sistema.wofganlicitacao.service.impl;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.sistema.wofganlicitacao.dto.login.LoginRecuperarDTO;
import com.sistema.wofganlicitacao.excecao.ExcecaoNoExiste;
import com.sistema.wofganlicitacao.model.Requisitante;
import com.sistema.wofganlicitacao.repository.RequisitanteRepository;
import com.sistema.wofganlicitacao.security.JWTUtil;
import com.sistema.wofganlicitacao.security.UserSS;
import com.sistema.wofganlicitacao.service.RecursoSistemaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecursoSistemaServiceImpl implements RecursoSistemaService {

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private RequisitanteRepository requisitanteRepository;
    @Autowired
    private EmailServiceImpl emailServiceImpl;
    
    @Override
    public void refreshToken(HttpServletResponse response) {
        
        UserSS usuarioLogin = UsuarioLogado.buscarUsuarioLogado();
        
        String token = jwtUtil.refreshTToken(usuarioLogin.getUsername());

        response.addHeader("Authorization", "Bearer " + token);
        
    }

    @Override
    public void enviarUmaNovaSenha(@Valid LoginRecuperarDTO loginDTO) {
        
        Optional<Requisitante> buscarRequisitante = requisitanteRepository.findByCnpj(loginDTO.getCnpj());

        if (buscarRequisitante.isEmpty()) {
            throw new ExcecaoNoExiste("Usuário não existe!");
        }
        
        emailServiceImpl.enviarUmaNovaSenhaRequisitante(buscarRequisitante.get().getId());
    }
    
}
