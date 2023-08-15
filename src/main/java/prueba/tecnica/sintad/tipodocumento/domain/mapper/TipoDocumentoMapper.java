package prueba.tecnica.sintad.tipodocumento.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import prueba.tecnica.sintad.tipodocumento.domain.dto.TipoDocumentoCreateDto;
import prueba.tecnica.sintad.tipodocumento.domain.dto.TipoDocumentoDto;
import prueba.tecnica.sintad.tipodocumento.domain.dto.TipoDocumentoUpdateDto;
import prueba.tecnica.sintad.tipodocumento.domain.model.TipoDocumento;
import java.util.List;

@Mapper
public interface TipoDocumentoMapper {

    TipoDocumentoMapper INSTANCE = Mappers.getMapper(TipoDocumentoMapper.class);

    TipoDocumentoDto tipoDocumentoATipoDocumentoDto(TipoDocumento tipoDocumento);

    TipoDocumento tipoDocumentoDtoATipoDocumento(TipoDocumentoDto tipoDocumentoDto);

    TipoDocumento tipoDocumentoCreateDtoATipoDocumento(TipoDocumentoCreateDto tipoDocumentoCreateDto);

    TipoDocumento tipoDocumentoUpdateDtoATipoDocumento(TipoDocumentoUpdateDto tipoDocumentoUpdateDto);

    List<TipoDocumentoDto> listaTipoDocumentoAListaTipoDocumentoDto(List<TipoDocumento> listaTipoDocumento);

}
