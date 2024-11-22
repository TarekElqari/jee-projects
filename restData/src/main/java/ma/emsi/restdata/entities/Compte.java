package ma.emsi.restdata.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    private TypeCompte type;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
