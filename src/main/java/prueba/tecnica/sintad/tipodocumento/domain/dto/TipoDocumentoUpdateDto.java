package prueba.tecnica.sintad.tipodocumento.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDocumentoUpdateDto {
    private int idTipoDocumento;
    private String codigo;
    private String nombre;
    private String descripcion;
    private int estado;
}
