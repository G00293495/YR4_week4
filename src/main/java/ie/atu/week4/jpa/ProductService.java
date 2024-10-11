package ie.atu.week4.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void add(Product product){
        productRepository.save(product);
    }
    public List<Product> deleteById(Long id){
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    public void update(Long id, Product product){
        Product updatedProduct = productRepository.getReferenceById(id);
        updatedProduct.setProductName(updatedProduct.getProductName());
        updatedProduct.setProductDescription(updatedProduct.getProductDescription());
        updatedProduct.setProductPrice(updatedProduct.getProductPrice());
    }
}
