package zd.zmk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zd.zmk.entities.Product;
import zd.zmk.entities.VendingMachine;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{

}
