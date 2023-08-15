package prueba.tecnica.sintad.auth.application;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import prueba.tecnica.sintad.auth.domain.MyUsuarioPrincipal;
import prueba.tecnica.sintad.usuario.domain.model.Usuario;
import prueba.tecnica.sintad.usuario.infrastructure.out.UsuarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public JwtUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLoginUsuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUsuarioPrincipal(usuario);
    }
}