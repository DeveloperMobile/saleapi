package one.digitalinnovation.saleapi.repository;

import one.digitalinnovation.saleapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
