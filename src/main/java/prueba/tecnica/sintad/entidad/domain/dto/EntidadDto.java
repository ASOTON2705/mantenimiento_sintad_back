package prueba.tecnica.sintad.entidad.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntidadDto {
    private int idEntidad;
    private String nombreTipoDocumento;
    private String nroDocumento;
    private String razonSocial;
    private String nombreComercial;
    private String nombreTipoContribuyente;
    private String direccion;
    private String telefono;
    private int estado;
}
