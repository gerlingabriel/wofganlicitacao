package com.sistema.wofganlicitacao.securityconf;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfModdelMapper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
