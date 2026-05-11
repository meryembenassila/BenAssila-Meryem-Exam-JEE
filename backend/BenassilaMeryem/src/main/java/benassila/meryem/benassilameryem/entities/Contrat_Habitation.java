package benassila.meryem.benassilameryem.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@DiscriminatorValue("HABI")
public class Contrat_Habitation extends Contrat{
    private  Type_Logement typeLogement;
    private  String adress;
    private  double superficie;

}
