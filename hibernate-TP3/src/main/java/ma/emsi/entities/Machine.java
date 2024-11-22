package ma.emsi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQuery(
        name = "findBetweenDateNative",
        query = "select * from machine where dateAchat between :d1 and :d2",
        resultClass = Machine.class
)
@NamedQuery(
        name = "findBetweenDate",
        query = "from Machine where dateAchat between :d1 and :d2"
)
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ref;

    @Temporal(TemporalType.DATE)
    private Date dateAchat;

    @ManyToOne
    private Salle salle;

    public Machine(String ref, Date dateAchat, Salle salle) {
        this.ref = ref;
        this.dateAchat = dateAchat;
        this.salle = salle;
    }
}

