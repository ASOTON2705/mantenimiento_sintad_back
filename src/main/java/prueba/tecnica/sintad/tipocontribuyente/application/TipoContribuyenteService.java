package prueba.tecnica.sintad.tipocontribuyente.application;

import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteCreateDto;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteDto;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteUpdateDto;
import java.util.List;

public interface TipoContribuyenteService {

    List<TipoContribuyenteDto> listarTipoContribuyentes();

    TipoContribuyenteDto obtenerTipoContribuyentePorId(int idTipoContribuyente);

    TipoContribuyenteDto registrarTipoContribuyente(TipoContribuyenteCreateDto tipoContribuyenteCreateDto);

    TipoContribuyenteDto actualizarTipoContribuyente(TipoContribuyenteUpdateDto tipoContribuyenteUpdateDto);

    String eliminarTipoContribuyente(int idTipoContribuyente);

}
