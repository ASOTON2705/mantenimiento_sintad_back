package prueba.tecnica.sintad.usuario.application.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import prueba.tecnica.sintad.tipousuario.infrastructure.out.TipoUsuarioRepository;
import prueba.tecnica.sintad.usuario.application.UsuarioService;
import prueba.tecnica.sintad.usuario.domain.dto.UsuarioCreateDto;
import prueba.tecnica.sintad.usuario.domain.dto.UsuarioDto;
import prueba.tecnica.sintad.usuario.domain.dto.UsuarioUpdateDto;
import prueba.tecnica.sintad.usuario.domain.mapper.UsuarioMapper;
import prueba.tecnica.sintad.usuario.domain.model.Usuario;
import prueba.tecnica.sintad.usuario.infrastructure.out.UsuarioRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, TipoUsuarioRepository tipoUsuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UsuarioDto> listarUsuarios() {
        return UsuarioMapper.INSTANCE.listaUsuarioAListaUsuarioDto(usuarioRepository.findAll());
    }

    @Override
    public UsuarioDto obtenerUsuarioPorId(int idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        UsuarioDto usuarioDto;
        usuarioDto = usuario.map(UsuarioMapper.INSTANCE::usuarioAUsuarioDto).orElse(null);
        return usuarioDto;
    }

    @Override
    public UsuarioDto registrarUsuario(UsuarioCreateDto usuarioCreateDto) {
        usuarioCreateDto.setContrasenaUsuario(passwordEncoder.encode(usuarioCreateDto.getContrasenaUsuario()));
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioCreateDtoAUsuario(usuarioCreateDto);
        return getUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto actualizarUsuario(UsuarioUpdateDto usuarioUpdateDto) {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioUpdateDtoAUsuario(usuarioUpdateDto);
        return getUsuarioDto(usuario);
    }

    private UsuarioDto getUsuarioDto(Usuario usuario) {
        Usuario respuestaEntity = usuarioRepository.save(usuario);
        UsuarioDto respuestaDto = UsuarioMapper.INSTANCE.usuarioAUsuarioDto(respuestaEntity);
        respuestaDto.setNombreTipoUsuario((tipoUsuarioRepository.findById(respuestaEntity.getTipoUsuario().getIdTipoUsuario()).get().getNombreTipoUsuario()));
        return respuestaDto;
    }

    @Override
    public String eliminarUsuario(int idUsuario) {
        Optional<Usuario> entities = usuarioRepository.findById(idUsuario);
        String resultado;
        if (entities.isPresent()) {
            usuarioRepository.deleteById(idUsuario);
            resultado = "Usuario eliminado";
        } else {
            resultado = "No se pudo eliminar el usuario";
        }
        return resultado;
    }
}
