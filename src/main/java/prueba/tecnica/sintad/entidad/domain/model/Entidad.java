package prueba.tecnica.sintad.entidad.domain.model;

import lombok.Data;
import prueba.tecnica.sintad.tipocontribuyente.domain.model.TipoContribuyente;
import prueba.tecnica.sintad.tipodocumento.domain.model.TipoDocumento;
import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_entidad")
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidad", length = 11, nullable = false)
    private int idEntidad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "nro_documento", length = 25, nullable = false)
    private String nroDocumento;

    @Column(name = "razon_social", length = 100, nullable = false)
    private String razonSocial;

    @Column(name = "nombre_comercial", length = 100)
    private String nombreComercial;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contribuyente")
    private TipoContribuyente tipoContribuyente;

    @Column(name = "direccion", length = 250)
    private String direccion;

    @Column(name = "telefono", length = 50)
    private String telefono;

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
