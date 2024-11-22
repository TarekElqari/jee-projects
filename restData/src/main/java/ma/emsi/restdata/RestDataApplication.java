package ma.emsi.restdata;

import ma.emsi.restdata.entities.Client;
import ma.emsi.restdata.entities.Compte;
import ma.emsi.restdata.entities.TypeCompte;
import ma.emsi.restdata.repo.ClientRepository;
import ma.emsi.restdata.repo.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class RestDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestDataApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository,
                            RepositoryRestConfiguration restConfiguration,
                            ClientRepository clientRepository){
        return args -> {

            Client c1 = clientRepository.save(new Client(null, "Tarik", null));
            Client c2 = clientRepository.save(new Client(null, "Soufiane", null));
            restConfiguration.exposeIdsFor(Compte.class);
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(),
                    TypeCompte.EPARGNE, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(),
                    TypeCompte.COURANT, c2));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(),
                    TypeCompte.EPARGNE, c1));

            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }
}
