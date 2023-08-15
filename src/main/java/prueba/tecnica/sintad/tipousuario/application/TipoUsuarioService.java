package prueba.tecnica.sintad.tipousuario.application;

import prueba.tecnica.sintad.tipousuario.domain.dto.TipoUsuarioCreateDto;
import prueba.tecnica.sintad.tipousuario.domain.dto.TipoUsuarioDto;
import prueba.tecnica.sintad.tipousuario.domain.dto.TipoUsuarioUpdateDto;
import java.util.List;

public interface TipoUsuarioService {

    List<TipoUsuarioDto> listarTipoUsuarios();

    TipoUsuarioDto obtenerTipoUsuarioPorId(int idTipoUsuario);

    TipoUsuarioDto registrarTipoUsuario(TipoUsuarioCreateDto tipoUsuarioCreateDto);

    TipoUsuarioDto actualizarTipoUsuario(TipoUsuarioUpdateDto tipoUsuarioUpdateDto);

    String eliminarTipoUsuario(int idTipoUsuario);

}
