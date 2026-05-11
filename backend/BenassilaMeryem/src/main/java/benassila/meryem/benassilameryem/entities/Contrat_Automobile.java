package benassila.meryem.benassilameryem.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@DiscriminatorValue("AUTO")

public class Contrat_Automobile extends Contrat{

    private Long numéro_immatriculation;
    private  String marque;
    private String modele;


}
