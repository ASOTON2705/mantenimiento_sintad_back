package prueba.tecnica.sintad.entidad.application;

import prueba.tecnica.sintad.entidad.domain.dto.EntidadCreateDto;
import prueba.tecnica.sintad.entidad.domain.dto.EntidadDto;
import prueba.tecnica.sintad.entidad.domain.dto.EntidadUpdateDto;
import java.util.List;

public interface EntidadService {
    List<EntidadDto> listarEntidades();

    EntidadDto obtenerEntidadPorId(int idEntidad);

    EntidadDto registrarEntidad(EntidadCreateDto entidadCreateDto);

    EntidadDto actualizarEntidad(EntidadUpdateDto entidadUpdateDto);

    String eliminarEntidad(int idEntidad);
}
