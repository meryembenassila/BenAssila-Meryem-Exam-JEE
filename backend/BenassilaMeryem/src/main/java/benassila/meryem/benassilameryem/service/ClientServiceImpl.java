package benassila.meryem.benassilameryem.service;

import benassila.meryem.benassilameryem.dtos.ClientDto;
import benassila.meryem.benassilameryem.dtos.ContratDto;
import benassila.meryem.benassilameryem.entities.Client;
import benassila.meryem.benassilameryem.entities.Contrat_Automobile;
import benassila.meryem.benassilameryem.entities.Contrat_Habitation;
import benassila.meryem.benassilameryem.exceptions.ClientNotFoundException;
import benassila.meryem.benassilameryem.mappers.Mappers;
import benassila.meryem.benassilameryem.repositories.ClientRepository;
import benassila.meryem.benassilameryem.repositories.ContratRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class ClientServiceImpl  implements ClientService{

    private ClientRepository clientRepository;
    private ContratRepository contratRepository;
    private Mappers mapperImp;

    @Override
    public ClientDto saveClient(ClientDto clientDto) {
        Client save = clientRepository.save(mapperImp.fromClientDTO(clientDto));
        return mapperImp.fromClient(save);
    }

    @Override
    public ClientDto getClient(Long id) throws ClientNotFoundException {
        Client client =clientRepository.findById(id).orElse(null);
        if(client==null) throw new ClientNotFoundException("Client not Found");
        return mapperImp.fromClient(client);
    }

    @Override
    public void deleteClient(Long id) throws ClientNotFoundException {
        Client client =clientRepository.findById(id).orElse(null);
        if(client==null) throw new ClientNotFoundException("Client not Found");
        clientRepository.deleteById(id);

    }

    @Override
    public List<ClientDto> getClients() {
        List<ClientDto> clientDtos=new ArrayList<>();
        clientRepository.findAll().forEach(client -> {
                    clientDtos.add(mapperImp.fromClient(client));
                }
        );
        return clientDtos;
    }

    @Override
    public List<ClientDto> search(String motif) {
        List<ClientDto> clientDtos=new ArrayList<>();
        clientRepository.findAllByNameContainsIgnoreCase(motif).forEach(client -> {
            clientDtos.add(mapperImp.fromClient(client));
        });

        return clientDtos;
    }


    //@Override
   // public List<ContratDto> gettcontratofuser(Long clientid) throws ClientNotFoundException {
     //   List<ContratDto> contratDtos=new ArrayList<>();
     //   Client client =clientRepository.findById(clientid).orElse(null);
     //   if(client==null) throw new ClientNotFoundException("Client not Found");

     //   contratRepository.findByClient_Id(clientid).forEach(contrat -> {
     //       if (contrat instanceof Contrat_Automobile){
       //         contratDtos.add(mapperImp.fromContratAutomobile((Contrat_Automobile) contrat));
        //    } else if (contrat instanceof Contrat_Habitation) {
         //       contratDtos.add(mapperImp.fromContratHabitation((Contrat_Habitation) contrat));
          //    else{
          //          contratDtos.add(mapperImp.fromContrat((Contrat_Habitation) contrat));

            //    }
           // }
       // });


       // return contratDtos;
    //}



}
