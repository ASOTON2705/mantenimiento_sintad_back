package prueba.tecnica.sintad.tipocontribuyente.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteCreateDto;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteDto;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteUpdateDto;
import prueba.tecnica.sintad.tipocontribuyente.domain.model.TipoContribuyente;
import java.util.List;

@Mapper
public interface TipoContribuyenteMapper {

    TipoContribuyenteMapper INSTANCE = Mappers.getMapper(TipoContribuyenteMapper.class);

    TipoContribuyenteDto tipoContribuyenteATipoContribuyenteDto(TipoContribuyente tipoContribuyente);

    TipoContribuyente tipoContribuyenteDtoATipoContribuyente(TipoContribuyenteDto tipoContribuyenteDto);

    TipoContribuyente tipoContribuyenteCreateDtoATipoContribuyente(TipoContribuyenteCreateDto tipoContribuyenteCreateDto);

    TipoContribuyente tipoContribuyenteUpdateDtoATipoContribuyente(TipoContribuyenteUpdateDto tipoContribuyenteUpdateDto);

    List<TipoContribuyenteDto> listaTipoContribuyenteAListaTipoContribuyenteDto(List<TipoContribuyente> listaTipoContribuyente);

}
