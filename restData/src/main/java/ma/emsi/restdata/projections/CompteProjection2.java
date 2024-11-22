package ma.emsi.restdata.projections;

import ma.emsi.restdata.entities.Compte;
import ma.emsi.restdata.entities.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile", types = Compte.class)
public interface CompteProjection2{
    public double getSolde();
    public TypeCompte getTypes();
}