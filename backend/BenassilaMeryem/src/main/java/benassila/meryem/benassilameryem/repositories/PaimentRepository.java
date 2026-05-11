package benassila.meryem.benassilameryem.repositories;

import benassila.meryem.benassilameryem.entities.Paiment;
import org.hibernate.boot.jaxb.mapping.spi.JaxbPersistentAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaimentRepository extends JpaRepository<Paiment,Long> {
}
