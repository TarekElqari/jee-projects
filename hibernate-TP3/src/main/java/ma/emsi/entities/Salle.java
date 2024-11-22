package ma.emsi.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "salles")
public class Salle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    @OneToMany(mappedBy = "salle", fetch = FetchType.EAGER)
    private List<Machine> machines;

    public Salle(String code) {
        this.code = code;
    }
}
