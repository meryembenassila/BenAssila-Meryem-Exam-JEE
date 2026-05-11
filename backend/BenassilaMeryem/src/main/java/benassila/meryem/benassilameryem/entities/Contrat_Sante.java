package benassila.meryem.benassilameryem.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@DiscriminatorValue("SANT")

public class Contrat_Sante extends Contrat{
    private  Niveau_Couverture niveauCouverture;
    private int nombre_personnes;
}
