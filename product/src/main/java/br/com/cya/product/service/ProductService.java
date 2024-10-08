package br.com.cya.product.service;

import br.com.cya.product.dto.CreateProductDto;
import br.com.cya.product.model.Product;
import br.com.cya.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(CreateProductDto createProductDto) {
        Product product = Product.builder()
                .name(createProductDto.name())
                .price(createProductDto.price())
                .userId(createProductDto.userId())
                .build();

        productRepository.save(product);
    }

    public Iterable<Product> listProducts() {
        return productRepository.findAll();
    }
}
