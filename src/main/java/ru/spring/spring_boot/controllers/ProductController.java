package ru.spring.spring_boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.spring.spring_boot.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("products", productService.getAll());
        return "products";
    }
    @GetMapping("/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    return "redirect:/products";
    }

}
