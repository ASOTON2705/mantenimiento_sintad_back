package prueba.tecnica.sintad.tipousuario.domain.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_tipo_usuario")
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario")
    private int idTipoUsuario;

    @Column(name = "nombre_tipo_usuario", length = 50, nullable = false)
    private String nombreTipoUsuario;

    @Column(name = "estado")
    private int estado;

    public String NombreEstado() {
        String nombreEstado = null;
        switch (estado) {
            case 0:
                nombreEstado = "Activo";
                break;
            case 1:
                nombreEstado = "Inactivo";
                break;
            default:
                nombreEstado = "";
        }
        return nombreEstado;
    }
}
