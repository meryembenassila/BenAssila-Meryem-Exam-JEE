package benassila.meryem.benassilameryem.mappers;

import benassila.meryem.benassilameryem.dtos.ClientDto;
import benassila.meryem.benassilameryem.dtos.Contrat_AutomobileDto;
import benassila.meryem.benassilameryem.dtos.Contrat_HAbitationDto;
import benassila.meryem.benassilameryem.entities.Client;
import benassila.meryem.benassilameryem.entities.Contrat_Automobile;
import benassila.meryem.benassilameryem.entities.Contrat_Habitation;
import lombok.Data;
import org.springframework.beans.BeanUtils;


@Data
public class mappers {

    public Client fromClientDTO(ClientDto clientDto){
        Client Client = new Client();
        BeanUtils.copyProperties(clientDto,Client);
        return Client;
    }


    public ClientDto fromClient(Client Client){
        ClientDto ClientDTO = new ClientDto();
        BeanUtils.copyProperties(Client,ClientDTO);
        return ClientDTO;
    }



    public Contrat_Habitation fromContratHabitationdto(Contrat_HAbitationDto contratHAbitationDto){
        Contrat_Habitation contratHabitation = new Contrat_Habitation();
        BeanUtils.copyProperties(contratHAbitationDto,contratHabitation);
        contratHabitation.setClient(fromClientDTO(contratHAbitationDto.getClientDto()));
        return  contratHabitation;
    }

    public Contrat_Automobile fromContratAutomobile(Contrat_AutomobileDto contrat_automobileDto){
        Contrat_Automobile contrat_automobile = new Contrat_Automobile();
        BeanUtils.copyProperties(contrat_automobileDto,contrat_automobile);
        contrat_automobile.setClient(fromClientDTO(contrat_automobileDto.getClientDto()));
        return  contrat_automobile;
    }


    public Contrat_HAbitationDto fromContratHabitation ( Contrat_Habitation contratHabitation){
        Contrat_HAbitationDto contratHAbitationDto = new Contrat_HAbitationDto();
        BeanUtils.copyProperties(contratHabitation,contratHAbitationDto);
        contratHAbitationDto.setType(contratHabitation.getClass().getSimpleName());
        contratHAbitationDto.setClientDto(fromClient(contratHabitation.getClient()));

        return  contratHAbitationDto;
    }


    public Contrat_AutomobileDto fromContratAutomobile ( Contrat_Automobile contrat_automobile){
        Contrat_AutomobileDto contrat_automobiledto = new Contrat_AutomobileDto();
        BeanUtils.copyProperties(contrat_automobile,contrat_automobiledto);
        contrat_automobiledto.setType(contrat_automobile.getClass().getSimpleName());
        contrat_automobiledto.setClientDto(fromClient(contrat_automobile.getClient()));

        return  contrat_automobiledto;
    }




}
