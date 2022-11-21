package ru.spring.spring_boot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.spring_boot.model.Product;
import ru.spring.spring_boot.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> getBiId(Long id) {
        return Optional.ofNullable(productRepository.getById(id));
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }
    public Product saveOrUpdate(Product product) {
        return productRepository.saveAndUpdate(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
