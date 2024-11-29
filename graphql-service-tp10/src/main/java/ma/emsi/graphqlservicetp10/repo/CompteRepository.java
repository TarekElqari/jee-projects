package ma.emsi.graphqlservicetp10.repo;


import ma.emsi.graphqlservicetp10.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
