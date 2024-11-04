package repository;

import model.Antivirus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Anotación que indica que esta interfaz es un repositorio
public interface AntivirusRepository extends JpaRepository<Antivirus, Long> {}