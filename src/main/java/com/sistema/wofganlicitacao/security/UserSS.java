package com.sistema.wofganlicitacao.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.sistema.wofganlicitacao.model.enumerado.Perfil;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSS implements UserDetails{

    private Long id;
    private String cnpj;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSS() {
    }

    public UserSS(Long id, String cnpj, String senha, Set<Perfil> perfis ){
        this.id = id;
        this.cnpj = cnpj;
        this.senha = senha;
        this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {        
        return senha;
    }

    @Override
    public String getUsername() {        
        return cnpj;
    }

    @Override
    public boolean isAccountNonExpired() {        
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {        
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {        
        return true;
    }

    @Override
    public boolean isEnabled() {        
        return true;
    }

    public boolean seNaoTemPerfilAdm() {
        return !getAuthorities().contains(new SimpleGrantedAuthority(Perfil.ADMIN.getDescricao()) );
    }


}
