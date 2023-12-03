package ma.ehtp.project.services;
import ma.ehtp.project.entities.Product;
import ma.ehtp.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void addRandomProduct() {
        Product product = new Product();
        Random random = new Random();
        product.setName(UUID.randomUUID().toString());
        product.setPrice(random.nextInt(50));
        product.setQuantity(random.nextInt(100));
        productRepository.save(product);
    }
}
