package prueba.tecnica.sintad.tipousuario.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.tecnica.sintad.tipousuario.domain.model.TipoUsuario;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
}
