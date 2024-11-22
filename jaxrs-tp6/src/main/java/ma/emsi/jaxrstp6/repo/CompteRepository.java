package ma.emsi.jaxrstp6.repo;

import ma.emsi.jaxrstp6.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
