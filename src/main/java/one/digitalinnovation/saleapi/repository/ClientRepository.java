package one.digitalinnovation.saleapi.repository;

import one.digitalinnovation.saleapi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
