package prueba.tecnica.sintad.tipocontribuyente.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.tecnica.sintad.tipocontribuyente.domain.model.TipoContribuyente;

@Repository
public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente, Integer> {
}
