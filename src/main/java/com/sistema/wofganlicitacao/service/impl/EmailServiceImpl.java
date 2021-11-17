package com.sistema.wofganlicitacao.service.impl;

import java.util.Random;

import com.sistema.wofganlicitacao.model.Requisitante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private BCryptPasswordEncoder password;
    @Autowired
    private RequisitanteServiceImpl requisitanteServiceImpl;

    private Random random = new Random();

    public void enviarUmaNovaSenhaRequisitante(Long id) {

        Requisitante buscarRequisitante = requisitanteServiceImpl.verificarSeExisteEmpresaRequisitante(id);

        String senhaNova = newPassword();
        buscarRequisitante.setSenha(password.encode(senhaNova));
        
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("email.para.estudos.java@gmail.com");
        message.setTo(buscarRequisitante.getEmail() ); 
        message.setSubject("SOLICITAÇÃO DE UMA NOVA SENHA"); 
        message.setText("Senha alterada para " +senhaNova);

        emailSender.send(message);

    }

    private String newPassword() {
        char[] vet = new char[10];

        for (int i=0; i<10; i++){
            vet[i] = sortearLetras();
        }

        return new String(vet);
    }

    private char sortearLetras() {
        int sorteioLetrasENUmerros = random.nextInt(3);

        if (sorteioLetrasENUmerros == 0) { // será um número
            return (char) (random.nextInt(10)+48);

        } else if (sorteioLetrasENUmerros == 1) { // minusculas
            return (char) (random.nextInt(26)+65);
        } else {
            return (char) (random.nextInt(26)+97);
        }
    }
    
}
