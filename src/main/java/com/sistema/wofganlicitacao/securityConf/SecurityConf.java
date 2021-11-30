package com.sistema.wofganlicitacao.securityConf;

import java.util.Arrays;
import java.util.List;

import com.sistema.wofganlicitacao.security.JWTAutenticacaoFilter;
import com.sistema.wofganlicitacao.security.JWTAutorizacaoFilter;
import com.sistema.wofganlicitacao.security.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConf extends WebSecurityConfigurerAdapter{

    @Autowired
    private Environment environment;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;

    List<String> allowedMethods = Arrays.asList("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");

    private static final String[] PUBLIC_MATCHERS = {
        "/h2-console/**",
        "/index/**"

    };

    private static final String[] PUBLIC_MATCHERS_GET = {
        "/categorias/**",
        "/produtos/**"
    };

    // End-point para cadastrar um Novo Usuário e recuperar senha
    private static final String[] PUBLIC_MATCHERS_POST = {
        "/empresas/**",
        "/fornecedores/**",
        "/autoricao/recuperarSenha/**"
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

         // habilitar uso h2 no navegador
         if (Arrays.asList(environment.getActiveProfiles()).contains("h2")) {
            http.headers().frameOptions().disable();            
        }

        http.cors()                                   //configuração para habilitar cors, mas na classe terá uma congiração "configurationSource"
        .and().csrf().disable()                        //como não termeos sessão pode desabilitar csrf
        .authorizeRequests()                       
            .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()  
            .antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
            .antMatchers(PUBLIC_MATCHERS).permitAll()
            .anyRequest().authenticated()
        .and().logout().logoutSuccessUrl("/index")
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)    
        .and()
            .addFilter(new JWTAutenticacaoFilter(authenticationManager(), jwtUtil))
            .addFilter(new JWTAutorizacaoFilter(authenticationManager(), jwtUtil, userDetailsService));
    }

    @Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
}
