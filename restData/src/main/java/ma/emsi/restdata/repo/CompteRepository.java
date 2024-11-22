package ma.emsi.restdata.repo;

import ma.emsi.restdata.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(path = "comptes", collectionResourceRel = "comptes",
itemResourceRel = "compte")
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
