package prueba.tecnica.sintad.usuario.domain.model;

import lombok.Data;
import prueba.tecnica.sintad.tipousuario.domain.model.TipoUsuario;
import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 90, nullable = false)
    private String apellido;

    @Column(name = "correo", length = 70, nullable = false)
    private String correo;

    @Column(name = "telefono", length = 15, nullable = false)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuario;

    @Column(name = "login_usuario", length = 50, nullable = false)
    private String loginUsuario;

    @Column(name = "contrasena_usuario", length = 350, nullable = false)
    private String contrasenaUsuario;

    @Column(name = "estado")
    private int estado;
}
