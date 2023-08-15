package prueba.tecnica.sintad.tipocontribuyente.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_tipo_contribuyente")
public class TipoContribuyente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_contribuyente", length = 11, nullable = false)
    private int idTipoContribuyente;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

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
