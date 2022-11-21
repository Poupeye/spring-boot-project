package ru.spring.spring_boot.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.spring.spring_boot.exceptions.ResourceNotFoundException;
import ru.spring.spring_boot.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getAll() {
        return Collections.unmodifiableList(products);
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "salo", 150.00));
        products.add(new Product(2L, "Beer", 100.00));
        products.add(new Product(3L, "pussy", 1500.00));
        products.add(new Product(4L, "meet", 450.00));
        products.add(new Product(5L, "vodka", 350.00));
    }

    public Product getById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("product not found"));
    }


    public Product saveAndUpdate(Product product) {
        if (product.getId() != null) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(product.getId())) {
                    products.set(i, product);
                    return product;
                }
            }
        }
        Long newId = products.stream().mapToLong(Product::getId).max().orElseGet(() -> 0L) + 1L;
        product.setId(newId);
        products.add(product);
        return product;
    }

    public void deleteById(Long id) {
       products.removeIf(product -> product.getId().equals(id));
    }
}
