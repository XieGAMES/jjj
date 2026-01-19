package zd.zmk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zd.zmk.entities.Product;
import zd.zmk.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;

    }
    public Product getProduct(Integer id){
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Integer id){
         productRepository.deleteById(id);
    }
}
