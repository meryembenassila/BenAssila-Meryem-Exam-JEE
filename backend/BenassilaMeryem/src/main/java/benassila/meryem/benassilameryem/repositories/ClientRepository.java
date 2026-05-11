package benassila.meryem.benassilameryem.repositories;

import benassila.meryem.benassilameryem.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client,Long> {
}
