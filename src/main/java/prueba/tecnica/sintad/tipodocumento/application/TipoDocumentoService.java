package prueba.tecnica.sintad.tipodocumento.application;

import prueba.tecnica.sintad.tipodocumento.domain.dto.TipoDocumentoCreateDto;
import prueba.tecnica.sintad.tipodocumento.domain.dto.TipoDocumentoDto;
import prueba.tecnica.sintad.tipodocumento.domain.dto.TipoDocumentoUpdateDto;
import java.util.List;

public interface TipoDocumentoService {

    List<TipoDocumentoDto> listarTipoDocumentos();

    TipoDocumentoDto obtenerTipoDocumentoPorId(int idTipoDocumento);

    TipoDocumentoDto registrarTipoDocumento(TipoDocumentoCreateDto tipoDocumentoCreateDto);

    TipoDocumentoDto actualizarTipoDocumento(TipoDocumentoUpdateDto tipoDocumentoUpdateDto);

    String eliminarTipoDocumento(int idTipoDocumento);

}
