package benassila.meryem.benassilameryem.dtos;

import benassila.meryem.benassilameryem.entities.Client;
import benassila.meryem.benassilameryem.entities.Status_Contrat;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
@Data

public class Contrat_AutomobileDto {

    private Long id;
    private Date date_souscription ;
    private Status_Contrat statusContrat;
    private Date date_validation ;
    private double mobtant_cotisation;
    private double dureé_contrat;
    private double taux;
    private ClientDto clientDto;
    private Long numéro_immatriculation;
    private  String marque;
    private String modele;
}
