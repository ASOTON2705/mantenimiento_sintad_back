package prueba.tecnica.sintad.entidad.application.impl;

import org.springframework.stereotype.Service;
import prueba.tecnica.sintad.entidad.application.EntidadService;
import prueba.tecnica.sintad.entidad.domain.dto.EntidadCreateDto;
import prueba.tecnica.sintad.entidad.domain.dto.EntidadDto;
import prueba.tecnica.sintad.entidad.domain.dto.EntidadUpdateDto;
import prueba.tecnica.sintad.entidad.domain.mapper.EntidadMapper;
import prueba.tecnica.sintad.entidad.domain.model.Entidad;
import prueba.tecnica.sintad.entidad.infrastructure.out.EntidadRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EntidadServiceImpl implements EntidadService {
    private final EntidadRepository entidadRepository;
    public EntidadServiceImpl(EntidadRepository entidadRepository) {
        this.entidadRepository = entidadRepository;
    }
    @Override
    public List<EntidadDto> listarEntidades() {
        return EntidadMapper.INSTANCE.listaEntidadAListaEntidadDto(entidadRepository.findAll());
    }

    @Override
    public EntidadDto obtenerEntidadPorId(int idEntidad) {
        Optional<Entidad> entidad = entidadRepository.findById(idEntidad);
        EntidadDto entidadDto;
        entidadDto = entidad.map(EntidadMapper.INSTANCE::entidadAEntidadDto).orElse(null);
        return entidadDto;
    }

    @Override
    public EntidadDto registrarEntidad(EntidadCreateDto entidadCreateDto) {
        Entidad entidad = EntidadMapper.INSTANCE.entidadCreateDtoAEntidad(entidadCreateDto);
        Entidad respuestaEntity = entidadRepository.save(entidad);
        EntidadDto respuestaDto = EntidadMapper.INSTANCE.entidadAEntidadDto(respuestaEntity);
        return respuestaDto;
    }

    @Override
    public EntidadDto actualizarEntidad(EntidadUpdateDto entidadUpdateDto) {
        Entidad entidad = EntidadMapper.INSTANCE.entidadUpdateDtoAEntidad(entidadUpdateDto);
        Entidad respuestaEntity = entidadRepository.save(entidad);
        EntidadDto respuestaDto = EntidadMapper.INSTANCE.entidadAEntidadDto(respuestaEntity);
        return respuestaDto;
    }

    @Override
    public String eliminarEntidad(int idEntidad) {
        Optional<Entidad> entities = entidadRepository.findById(idEntidad);
        String resultado;
        if (entities.isPresent()) {
            entidadRepository.deleteById(idEntidad);
            resultado = "Entidad eliminada";
        } else {
            resultado = "No se pudo eliminar la entidad";
        }
        return resultado;
    }
}
