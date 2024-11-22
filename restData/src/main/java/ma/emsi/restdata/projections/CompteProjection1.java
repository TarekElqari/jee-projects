package ma.emsi.restdata.projections;


import ma.emsi.restdata.entities.Compte;
import ma.emsi.restdata.entities.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

import java.lang.reflect.Type;

@Projection(name = "solde", types = Compte.class)
public interface CompteProjection1 {
    public double getSolde();
}

