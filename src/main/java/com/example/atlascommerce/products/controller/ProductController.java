package com.example.atlascommerce.products.controller;

import com.example.atlascommerce.products.dto.ProductCreateDTO;
import com.example.atlascommerce.products.dto.ProductResponseDTO;
import com.example.atlascommerce.products.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){this.productService = productService;}


    @GetMapping
    public List<ProductResponseDTO> findProduct(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false)BigDecimal price
            ){
        return productService.withFilters(
                name, description, price
        );
    }

    @GetMapping("/{id}")
    public ProductResponseDTO findByID(@PathVariable Long id) {return productService.findById(id);}


    @PostMapping
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductCreateDTO dto){
        return productService.createProduct(dto);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductCreateDTO dto
    ){
        return productService.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
