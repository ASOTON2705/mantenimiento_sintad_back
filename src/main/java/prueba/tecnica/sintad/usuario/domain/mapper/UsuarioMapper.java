package prueba.tecnica.sintad.usuario.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import prueba.tecnica.sintad.usuario.domain.dto.UsuarioCreateDto;
import prueba.tecnica.sintad.usuario.domain.dto.UsuarioDto;
import prueba.tecnica.sintad.usuario.domain.dto.UsuarioUpdateDto;
import prueba.tecnica.sintad.usuario.domain.model.Usuario;
import java.util.List;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDto usuarioAUsuarioDto(Usuario usuario);

    Usuario usuarioDtoAUsuario(UsuarioDto usuarioDto);

    Usuario usuarioCreateDtoAUsuario(UsuarioCreateDto usuarioCreateDto);

    Usuario usuarioUpdateDtoAUsuario(UsuarioUpdateDto usuarioUpdateDto);

    List<UsuarioDto> listaUsuarioAListaUsuarioDto(List<Usuario> listaUsuario);

}
