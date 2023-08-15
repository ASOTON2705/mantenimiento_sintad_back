package prueba.tecnica.sintad.tipodocumento.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class TipoDocumentoDto {
    private int idTipoDocumento;
    private String codigo;
    private String nombre;
    private String descripcion;
    private int estado;
}
