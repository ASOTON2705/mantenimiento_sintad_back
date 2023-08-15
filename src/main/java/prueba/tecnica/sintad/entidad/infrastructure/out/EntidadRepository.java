package prueba.tecnica.sintad.entidad.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.tecnica.sintad.entidad.domain.model.Entidad;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Integer> {
}
