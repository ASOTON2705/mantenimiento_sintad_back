package prueba.tecnica.sintad.usuario.application;

import prueba.tecnica.sintad.usuario.domain.dto.UsuarioCreateDto;
import prueba.tecnica.sintad.usuario.domain.dto.UsuarioDto;
import prueba.tecnica.sintad.usuario.domain.dto.UsuarioUpdateDto;
import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> listarUsuarios();

    UsuarioDto obtenerUsuarioPorId(int idUsuario);

    UsuarioDto registrarUsuario(UsuarioCreateDto usuarioCreateDto);

    UsuarioDto actualizarUsuario(UsuarioUpdateDto usuarioUpdateDto);

    String eliminarUsuario(int idUsuario);

}
