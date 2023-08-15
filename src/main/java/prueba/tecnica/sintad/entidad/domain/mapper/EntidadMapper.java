package prueba.tecnica.sintad.entidad.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import prueba.tecnica.sintad.entidad.domain.dto.EntidadCreateDto;
import prueba.tecnica.sintad.entidad.domain.dto.EntidadDto;
import prueba.tecnica.sintad.entidad.domain.dto.EntidadUpdateDto;
import prueba.tecnica.sintad.entidad.domain.model.Entidad;
import java.util.List;

@Mapper
public interface EntidadMapper {
    EntidadMapper INSTANCE = Mappers.getMapper(EntidadMapper.class);

    EntidadDto entidadAEntidadDto(Entidad entidad);
    Entidad entidadDtoAEntidad(EntidadDto entidadDto);
    Entidad entidadCreateDtoAEntidad(EntidadCreateDto entidadCreateDto);
    Entidad entidadUpdateDtoAEntidad(EntidadUpdateDto entidadUpdateDto);
    List<EntidadDto> listaEntidadAListaEntidadDto(List<Entidad> listaEntidad);
}
