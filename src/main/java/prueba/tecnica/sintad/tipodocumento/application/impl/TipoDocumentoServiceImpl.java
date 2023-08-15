package prueba.tecnica.sintad.tipodocumento.application.impl;

import org.springframework.stereotype.Service;
import prueba.tecnica.sintad.tipodocumento.application.TipoDocumentoService;
import prueba.tecnica.sintad.tipodocumento.domain.dto.TipoDocumentoCreateDto;
import prueba.tecnica.sintad.tipodocumento.domain.dto.TipoDocumentoDto;
import prueba.tecnica.sintad.tipodocumento.domain.dto.TipoDocumentoUpdateDto;
import prueba.tecnica.sintad.tipodocumento.domain.mapper.TipoDocumentoMapper;
import prueba.tecnica.sintad.tipodocumento.domain.model.TipoDocumento;
import prueba.tecnica.sintad.tipodocumento.infrastructure.out.TipoDocumentoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoServiceImpl(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    @Override
    public List<TipoDocumentoDto> listarTipoDocumentos() {
        return TipoDocumentoMapper.INSTANCE.listaTipoDocumentoAListaTipoDocumentoDto(tipoDocumentoRepository.findAll());
    }

    @Override
    public TipoDocumentoDto obtenerTipoDocumentoPorId(int idTipoDocumento) {
        Optional<TipoDocumento> tipoDocumento = tipoDocumentoRepository.findById(idTipoDocumento);
        TipoDocumentoDto tipoDocumentoDto;
        if (tipoDocumento.isPresent()) {
            tipoDocumentoDto = TipoDocumentoMapper.INSTANCE.tipoDocumentoATipoDocumentoDto(tipoDocumento.get());
        } else {
            tipoDocumentoDto = null;
        }
        return tipoDocumentoDto;
    }

    @Override
    public TipoDocumentoDto registrarTipoDocumento(TipoDocumentoCreateDto tipoDocumentoCreateDto) {
        TipoDocumento tipoDocumento = TipoDocumentoMapper.INSTANCE.tipoDocumentoCreateDtoATipoDocumento(tipoDocumentoCreateDto);
        TipoDocumento respuestaEntity = tipoDocumentoRepository.save(tipoDocumento);
        TipoDocumentoDto respuestaDto = TipoDocumentoMapper.INSTANCE.tipoDocumentoATipoDocumentoDto(respuestaEntity);
        return respuestaDto;
    }

    @Override
    public TipoDocumentoDto actualizarTipoDocumento(TipoDocumentoUpdateDto tipoDocumentoUpdateDto) {
        TipoDocumento tipoDocumento = TipoDocumentoMapper.INSTANCE.tipoDocumentoUpdateDtoATipoDocumento(tipoDocumentoUpdateDto);
        TipoDocumento respuestaEntity = tipoDocumentoRepository.save(tipoDocumento);
        TipoDocumentoDto respuestaDto = TipoDocumentoMapper.INSTANCE.tipoDocumentoATipoDocumentoDto(respuestaEntity);
        return respuestaDto;
    }

    @Override
    public String eliminarTipoDocumento(int idTipoDocumento) {
        Optional<TipoDocumento> entities = tipoDocumentoRepository.findById(idTipoDocumento);
        String resultado;
        if (entities.isPresent()) {
            tipoDocumentoRepository.deleteById(idTipoDocumento);
            resultado = "Tipo de documento eliminado";
        } else {
            resultado = "No se pudo eliminar el tipo de documento";
        }
        return resultado;
    }
}
