package benassila.meryem.benassilameryem.dtos;

import benassila.meryem.benassilameryem.entities.Status_Contrat;
import benassila.meryem.benassilameryem.entities.Type_Logement;
import lombok.Data;

import java.util.Date;
@Data
public class Contrat_HAbitationDto extends ContratDto {
    private Long id;
    private Date date_souscription ;
    private Status_Contrat statusContrat;
    private Date date_validation ;
    private double mobtant_cotisation;
    private double dureé_contrat;
    private double taux;
    private ClientDto clientDto;
    private Type_Logement typeLogement;
    private  String adress;
    private  double superficie;
}
