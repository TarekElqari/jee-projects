package ma.emsi.graphqlservicetp10.resolvers;

import ma.emsi.graphqlservicetp10.entity.Compte;
import ma.emsi.graphqlservicetp10.entity.Transaction;
import ma.emsi.graphqlservicetp10.repo.CompteRepository;
import ma.emsi.graphqlservicetp10.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TransactionGraphQLController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CompteRepository compteRepository;

    @QueryMapping
    public List<Transaction> getTransactionsByCompteId(Long compteId) {
        return transactionRepository.findAll()
                .stream()
                .filter(transaction -> transaction.getCompte().getId().equals(compteId))
                .toList();
    }

    @MutationMapping
    public Transaction createTransaction(Long compteId, Double amount, String type) {
        Compte compte = compteRepository.findById(compteId).orElse(null);
        if (compte == null) return null;

        if (type.equals("RETRAIT") && compte.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        Transaction transaction = new Transaction();
        transaction.setCompte(compte);
        transaction.setAmount(amount);
        transaction.setType(type);
        transaction.setDate(LocalDateTime.now());

        if (type.equals("RETRAIT")) {
            compte.setBalance(compte.getBalance() - amount);
        } else if (type.equals("DEPOT")) {
            compte.setBalance(compte.getBalance() + amount);
        }

        compteRepository.save(compte);
        return transactionRepository.save(transaction);
    }
}
