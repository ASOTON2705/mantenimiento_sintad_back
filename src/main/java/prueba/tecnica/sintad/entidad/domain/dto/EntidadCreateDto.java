package prueba.tecnica.sintad.entidad.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntidadCreateDto {
    private int idTipoDocumento;
    private String nroDocumento;
    private String razonSocial;
    private String nombreComercial;
    private int idTipoContribuyente;
    private String direccion;
    private String telefono;
    private int estado;
}
