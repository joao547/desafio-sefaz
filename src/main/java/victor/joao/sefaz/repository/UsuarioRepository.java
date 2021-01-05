package victor.joao.sefaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import victor.joao.sefaz.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
