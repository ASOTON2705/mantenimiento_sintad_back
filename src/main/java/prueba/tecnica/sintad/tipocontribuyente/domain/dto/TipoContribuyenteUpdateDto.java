package prueba.tecnica.sintad.tipocontribuyente.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoContribuyenteUpdateDto {
    private int idTipoContribuyente;
    private String nombre;
    private int estado;
}
