package prueba.tecnica.sintad.usuario.domain.dto;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsuarioUpdateDto {

    private int idUsuario;
    private int idTipoUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String loginUsuario;
    private String contrasenaUsuario;
    private int estado;
}
