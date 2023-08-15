package prueba.tecnica.sintad.tipousuario.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import prueba.tecnica.sintad.tipousuario.domain.dto.TipoUsuarioCreateDto;
import prueba.tecnica.sintad.tipousuario.domain.dto.TipoUsuarioDto;
import prueba.tecnica.sintad.tipousuario.domain.dto.TipoUsuarioUpdateDto;
import prueba.tecnica.sintad.tipousuario.domain.model.TipoUsuario;

import java.util.List;

@Mapper
public interface TipoUsuarioMapper {

    TipoUsuarioMapper INSTANCE = Mappers.getMapper(TipoUsuarioMapper.class);

    TipoUsuarioDto tipoUsuarioATipoUsuarioDto(TipoUsuario tipoUsuario);

    TipoUsuario tipoUsuarioDtoATipoUsuario(TipoUsuarioDto tipoUsuarioDto);

    TipoUsuario tipoUsuarioCreateDtoATipoUsuario(TipoUsuarioCreateDto tipoUsuarioCreateDto);

    TipoUsuario tipoUsuarioUpdateDtoATipoUsuario(TipoUsuarioUpdateDto tipoUsuarioUpdateDto);

    List<TipoUsuarioDto> listaTipoUsuarioAListaTipoUsuarioDto(List<TipoUsuario> listaTipoUsuario);

}
