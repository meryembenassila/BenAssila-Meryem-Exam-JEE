package benassila.meryem.benassilameryem.repositories;

import benassila.meryem.benassilameryem.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository  extends JpaRepository<Client,Long> {

    List<Client> findAllByNameContainsIgnoreCase(String motif);
}
