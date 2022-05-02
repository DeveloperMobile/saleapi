package one.digitalinnovation.saleapi.repository;

import one.digitalinnovation.saleapi.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
