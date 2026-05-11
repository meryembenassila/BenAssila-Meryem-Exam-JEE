package benassila.meryem.benassilameryem.dtos;

import benassila.meryem.benassilameryem.entities.Type_Paiment;
import lombok.Data;


import java.util.Date;
@Data

public class PaimentDto {
    private Long id;
    private Date date;
    private double montant;
    private Type_Paiment typePaiment;

}
