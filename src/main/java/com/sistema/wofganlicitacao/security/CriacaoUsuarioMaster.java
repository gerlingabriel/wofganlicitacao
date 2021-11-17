package com.sistema.wofganlicitacao.security;

import com.sistema.wofganlicitacao.model.Requisitante;
import com.sistema.wofganlicitacao.model.enumerado.Perfil;
import com.sistema.wofganlicitacao.repository.RequisitanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CriacaoUsuarioMaster implements CommandLineRunner{

    @Autowired
    private RequisitanteRepository requisitanteRepository;

    @Override
    public void run(String... args) throws Exception {
        
            if (requisitanteRepository.findByCnpj("11111111111111").isEmpty()) {

                Requisitante requisitante = new Requisitante();
                requisitante.setEmail("gerlin.gabriel@gmail.com");
                requisitante.setCnpj("11111111111111");
                requisitante.setSenha(new BCryptPasswordEncoder().encode("123"));
                requisitante.setNomeSocial("Registro Master");
                requisitante.addPerfil(Perfil.CLIENTE);
                requisitante.addPerfil(Perfil.ADMIN);

                requisitanteRepository.save(requisitante);
        }
    }    
}

