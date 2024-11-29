package ma.emsi.graphqlservicetp10.resolvers;

import ma.emsi.graphqlservicetp10.entity.Compte;
import ma.emsi.graphqlservicetp10.entity.TypeCompte;
import ma.emsi.graphqlservicetp10.repo.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompteGraphQLController {

    @Autowired
    private CompteRepository compteRepository;

    @QueryMapping
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    @QueryMapping
    public Compte getCompteById(Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Compte createCompte(String owner, TypeCompte typeCompte, Double balance) {
        Compte compte = new Compte();
        compte.setOwner(owner);
        compte.setTypeCompte(typeCompte);
        compte.setBalance(balance);
        return compteRepository.save(compte);
    }

    @MutationMapping
    public Compte updateCompte(Long id, String owner, TypeCompte typeCompte, Double balance) {
        Compte compte = compteRepository.findById(id).orElse(null);
        if (compte != null) {
            if (owner != null) compte.setOwner(owner);
            if (typeCompte != null) compte.setTypeCompte(typeCompte);
            if (balance != null) compte.setBalance(balance);
            return compteRepository.save(compte);
        }
        return null;
    }

    @MutationMapping
    public String deleteCompte(Long id) {
        compteRepository.deleteById(id);
        return "Compte deleted successfully!";
    }
}
