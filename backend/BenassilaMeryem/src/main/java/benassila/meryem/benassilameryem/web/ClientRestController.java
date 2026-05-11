package benassila.meryem.benassilameryem.web;

import benassila.meryem.benassilameryem.dtos.ClientDto;
import benassila.meryem.benassilameryem.exceptions.ClientNotFoundException;
import benassila.meryem.benassilameryem.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ClientRestController {
    private ClientService clientService;



    @PreAuthorize("hasAuthority('SCOPE_USER')")
    @GetMapping("/clients")
    List<ClientDto> getClients(){
        return clientService.getClients();
    }

    @PreAuthorize("hasAuthority('SCOPE_USER')")
    @GetMapping("/clients/search")
    List<ClientDto> search(@RequestParam(name = "motif", defaultValue = "")String motif){
        return clientService.search(motif);
    }

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @DeleteMapping("/clients/delete/{id}")
    void deleteClient(@PathVariable Long id) throws ClientNotFoundException {
        clientService.deleteClient(id);
    }


    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PostMapping("/clients/save")
    ClientDto saveClient(@RequestBody ClientDto clientDto){
        return clientService.saveClient(clientDto);
    }





}
