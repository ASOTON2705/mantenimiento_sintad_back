package prueba.tecnica.sintad.usuario.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import prueba.tecnica.sintad.usuario.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "SELECT u FROM Usuario u WHERE u.loginUsuario = :username")
    Usuario findByLoginUsuario(@Param("username") String loginUsuario);
}
