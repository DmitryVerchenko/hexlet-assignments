package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.Comparator;
import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping(path = "")
    public List<Product> indexPriceBetween(@RequestParam(defaultValue = "0") Integer min,
                                           @RequestParam(required = false) Integer max) {
        max = max != null ? max : productRepository.findAll().stream()
                .map(Product::getPrice)
                .max(Comparator.naturalOrder())
                .get();
        return productRepository.findByPriceBetweenOrderByPrice(min, max);
    }
        // END

        @GetMapping(path = "/{id}")
        public Product show ( @PathVariable long id){

            var product = productRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

            return product;
        }
    }
