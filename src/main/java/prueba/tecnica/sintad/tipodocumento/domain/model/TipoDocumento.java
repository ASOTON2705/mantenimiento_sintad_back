package prueba.tecnica.sintad.tipodocumento.domain.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_tipo_documento")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento", length = 11, nullable = false)
    private int idTipoDocumento;

    @Column(name = "codigo", length = 20, nullable = false)
    private String codigo;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "estado", columnDefinition = "BIT", length = 1, nullable = false)
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
