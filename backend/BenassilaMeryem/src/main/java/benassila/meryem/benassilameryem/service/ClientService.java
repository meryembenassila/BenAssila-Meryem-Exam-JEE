package benassila.meryem.benassilameryem.service;


import benassila.meryem.benassilameryem.dtos.ClientDto;
import benassila.meryem.benassilameryem.dtos.ContratDto;
import benassila.meryem.benassilameryem.exceptions.ClientNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


public interface  ClientService {

    ClientDto saveClient(ClientDto clientDto);
    ClientDto getClient(Long id) throws ClientNotFoundException;
    void deleteClient(Long id) throws ClientNotFoundException;
    List<ClientDto> getClients();
    List<ClientDto>  search(String motif);


    //List<ContratDto> gettcontratofuser(Long clientid) throws ClientNotFoundException;
}
