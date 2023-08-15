package prueba.tecnica.sintad.tipousuario.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoUsuarioUpdateDto {
    private int idTipoUsuario;
    private String nombreTipoUsuario;
    private int estado;
}
