package com.example.atlascommerce.products.controller;

import com.example.atlascommerce.products.dto.ProductCreateDTO;
import com.example.atlascommerce.products.dto.ProductResponseDTO;
import com.example.atlascommerce.products.repository.ProductRepository;
import com.example.atlascommerce.products.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){this.productService = productService;}

    /// Revisão
    ///@GetMapping("/{id}")
   /// public ProductResponseDTO buscarPorId(@PathVariable Long id){
    ///    return productService.findById(id);
    ///}
    ///

    @PostMapping
    public ProductResponseDTO criarAnimal(@Valid @RequestBody ProductCreateDTO dto){
        return productService.createProduct(dto);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO atualizarAnimal(
            @PathVariable Long id,
            @Valid @RequestBody ProductCreateDTO dto
    ){
        return productService.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarAnimal(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
