package prueba.tecnica.sintad.usuario.domain.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;


@Getter
@Setter
public class UsuarioDto {
    private int idUsuario;
    private String nombreTipoUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String loginUsuario;
    private String contrasenaUsuario;
    private int estado;
}
