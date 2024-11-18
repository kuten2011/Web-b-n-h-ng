package CNJV.lab10.Repository;

import CNJV.lab10.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductsByBrandInAndPriceBetween(List<String> brands, double firstPrice, double secondPrice);

    List<Product> findProductsByPriceBetween(double minPrice, double maxPrice);

    List<Product> findProductsByBrandIn(List<String> brands);

    List<Product> findProductsByNameContainingIgnoreCase(String name);
}
