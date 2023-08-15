package prueba.tecnica.sintad.tipocontribuyente.application.impl;

import org.springframework.stereotype.Service;
import prueba.tecnica.sintad.tipocontribuyente.application.TipoContribuyenteService;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteCreateDto;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteDto;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteUpdateDto;
import prueba.tecnica.sintad.tipocontribuyente.domain.mapper.TipoContribuyenteMapper;
import prueba.tecnica.sintad.tipocontribuyente.domain.model.TipoContribuyente;
import prueba.tecnica.sintad.tipocontribuyente.infrastructure.out.TipoContribuyenteRepository;
import prueba.tecnica.sintad.tipodocumento.domain.dto.TipoDocumentoDto;
import prueba.tecnica.sintad.tipodocumento.domain.mapper.TipoDocumentoMapper;
import prueba.tecnica.sintad.tipodocumento.domain.model.TipoDocumento;
import prueba.tecnica.sintad.tipodocumento.infrastructure.out.TipoDocumentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TipoContribuyenteServiceImpl implements TipoContribuyenteService {

    private final TipoContribuyenteRepository tipoContribuyenteRepository;

    public TipoContribuyenteServiceImpl(TipoContribuyenteRepository tipoContribuyenteRepository) {
        this.tipoContribuyenteRepository = tipoContribuyenteRepository;
    }

    @Override
    public List<TipoContribuyenteDto> listarTipoContribuyentes() {
        return TipoContribuyenteMapper.INSTANCE.listaTipoContribuyenteAListaTipoContribuyenteDto(tipoContribuyenteRepository.findAll());
    }

    @Override
    public TipoContribuyenteDto obtenerTipoContribuyentePorId(int idTipoContribuyente) {
        Optional<TipoContribuyente> tipoContribuyente = tipoContribuyenteRepository.findById(idTipoContribuyente);
        TipoContribuyenteDto tipoContribuyenteDto;
        if (tipoContribuyente.isPresent()) {
            tipoContribuyenteDto = TipoContribuyenteMapper.INSTANCE.tipoContribuyenteATipoContribuyenteDto(tipoContribuyente.get());
        } else {
            tipoContribuyenteDto = null;
        }
        return tipoContribuyenteDto;
    }

    @Override
    public TipoContribuyenteDto registrarTipoContribuyente(TipoContribuyenteCreateDto tipoContribuyenteCreateDto) {
        TipoContribuyente tipoContribuyente = TipoContribuyenteMapper.INSTANCE.tipoContribuyenteCreateDtoATipoContribuyente(tipoContribuyenteCreateDto);
        TipoContribuyente respuestaEntity = tipoContribuyenteRepository.save(tipoContribuyente);
        TipoContribuyenteDto respuestaDto = TipoContribuyenteMapper.INSTANCE.tipoContribuyenteATipoContribuyenteDto(respuestaEntity);
        return respuestaDto;
    }

    @Override
    public TipoContribuyenteDto actualizarTipoContribuyente(TipoContribuyenteUpdateDto tipoContribuyenteUpdateDto) {
        TipoContribuyente tipoContribuyente = TipoContribuyenteMapper.INSTANCE.tipoContribuyenteUpdateDtoATipoContribuyente(tipoContribuyenteUpdateDto);
        TipoContribuyente respuestaEntity = tipoContribuyenteRepository.save(tipoContribuyente);
        TipoContribuyenteDto respuestaDto = TipoContribuyenteMapper.INSTANCE.tipoContribuyenteATipoContribuyenteDto(respuestaEntity);
        return respuestaDto;
    }

    @Override
    public String eliminarTipoContribuyente(int idTipoContribuyente) {
        Optional<TipoContribuyente> entities = tipoContribuyenteRepository.findById(idTipoContribuyente);
        String resultado;
        if (entities.isPresent()) {
            tipoContribuyenteRepository.deleteById(idTipoContribuyente);
            resultado = "Tipo de contribuyente eliminado";
        } else {
            resultado = "No se pudo eliminar el tipo de contribuyente";
        }
        return resultado;
    }
}
