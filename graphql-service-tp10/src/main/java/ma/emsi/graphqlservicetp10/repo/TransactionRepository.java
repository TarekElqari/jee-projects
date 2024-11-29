package ma.emsi.graphqlservicetp10.repo;


import ma.emsi.graphqlservicetp10.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}