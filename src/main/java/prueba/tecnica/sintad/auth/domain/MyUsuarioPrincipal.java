package prueba.tecnica.sintad.auth.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import prueba.tecnica.sintad.usuario.domain.model.Usuario;
import java.util.Collection;
import java.util.Collections;

public class MyUsuarioPrincipal implements UserDetails {
    private final Usuario usuario;

    public MyUsuarioPrincipal(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String getUsername() {
        return usuario.getLoginUsuario();
    }

    @Override
    public String getPassword() {
        return usuario.getContrasenaUsuario();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.<GrantedAuthority>singletonList(new SimpleGrantedAuthority("User"));
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

    public Usuario getAppUser() {
        return usuario;
    }
}
