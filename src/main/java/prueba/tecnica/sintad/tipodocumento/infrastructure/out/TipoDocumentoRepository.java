package prueba.tecnica.sintad.tipodocumento.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.tecnica.sintad.tipodocumento.domain.model.TipoDocumento;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}
