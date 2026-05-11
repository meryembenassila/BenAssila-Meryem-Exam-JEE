package benassila.meryem.benassilameryem.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 4)

public abstract class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date_souscription ;
    private Status_Contrat statusContrat;
    private Date date_validation ;
    private double mobtant_cotisation;
    private double dureé_contrat;
    private double taux;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "contrat")
    private List<Paiment> paiments;






}
