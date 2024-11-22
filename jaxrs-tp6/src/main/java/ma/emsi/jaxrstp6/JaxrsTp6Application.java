package ma.emsi.jaxrstp6;

import ma.emsi.jaxrstp6.entities.Compte;
import ma.emsi.jaxrstp6.entities.TypeCompte;
import ma.emsi.jaxrstp6.repo.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class JaxrsTp6Application {

    public static void main(String[] args) {

        SpringApplication.run(JaxrsTp6Application.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository){
        return args -> {
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(),
                    TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(),
                    TypeCompte.COURANT));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(),
                    TypeCompte.EPARGNE));

            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }

}
