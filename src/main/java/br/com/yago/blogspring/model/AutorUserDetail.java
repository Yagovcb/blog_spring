package br.com.yago.blogspring.model;

import br.com.yago.blogspring.service.AutorServico;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AutorUserDetail extends Autor implements UserDetails {

    private static final long serialVersionUID = 1L;

    public AutorUserDetail(Autor autor){
        super(autor);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getFuncoes();
    }

    @Override
    public String getPassword() {
        return this.getSenha();
    }

    @Override
    public String getUsername() {
        return this.getUsuario();
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
}
