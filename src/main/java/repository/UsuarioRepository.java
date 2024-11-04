package repository;

import model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Anotación que indica que esta interfaz es un repositorio
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}