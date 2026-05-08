package br.com.senain116.autoescolan116.application.core.domain.model;

import br.com.senain116.autoescolan116.application.core.domain.enums.Perfil;
import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class Usuario implements UserDetails {
    private Long id;
    private String login;
    private String senha;
    private boolean ativo = true;

    private Perfil perfil;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + perfil.name()));
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
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

    public Usuario() {
    }

    public Usuario(Long id, String login, String senha, boolean ativo, Perfil perfil) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isAtivo() {
        return this.ativo = ativo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void atualizarSenha(String senhaNovaCriptografada) {
        this.senha = senhaNovaCriptografada;
    }

    public void atualizarUsuario(Long id ,String login, boolean ativo, Perfil perfil){
        this.id = id;
        this.login = login;
        this.ativo = ativo;
        this.perfil =perfil;
    }
}