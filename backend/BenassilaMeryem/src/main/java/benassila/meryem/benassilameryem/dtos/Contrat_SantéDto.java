package benassila.meryem.benassilameryem.dtos;

import benassila.meryem.benassilameryem.entities.Niveau_Couverture;
import benassila.meryem.benassilameryem.entities.Status_Contrat;
import lombok.Data;

import java.util.Date;

@Data

public class Contrat_SantéDto extends ContratDto {

    private Long id;
    private Date date_souscription ;
    private Status_Contrat statusContrat;
    private Date date_validation ;
    private double mobtant_cotisation;
    private double dureé_contrat;
    private double taux;
    private ClientDto clientDto;
    private Niveau_Couverture niveauCouverture;
    private int nombre_personnes;
}
