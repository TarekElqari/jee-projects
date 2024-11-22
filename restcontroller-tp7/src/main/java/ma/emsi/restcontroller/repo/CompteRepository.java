package ma.emsi.restcontroller.repo;

import ma.emsi.restcontroller.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
