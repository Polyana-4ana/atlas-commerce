package com.example.atlascommerce.products.service;

import com.example.atlascommerce.products.domain.Product;
import com.example.atlascommerce.products.dto.ProductCreateDTO;
import com.example.atlascommerce.products.dto.ProductResponseDTO;
import com.example.atlascommerce.products.repository.ProductRepository;
import com.example.atlascommerce.products.repository.ProductSpecification;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO forDTO(Product product){
        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());

        return dto;
    }

    public ProductResponseDTO createProduct(ProductCreateDTO dto){
        Product product = new Product();

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());

        Product saved = productRepository.save(product);

        return forDTO(saved);
    }

    public List<ProductResponseDTO> findAll(){
        return productRepository.findAll()
                .stream()
                .map(this::forDTO)
                .toList();
    }

    public ProductResponseDTO findById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found" + id));

        return forDTO(product);
    }

    public List<ProductResponseDTO> withFilters(
            String name,
            String description,
            BigDecimal price
    ) {

        Specification<Product> spc = (root, query, cb) -> cb.conjunction();

        if (name != null && !name.isBlank()){
            name = name.trim().toLowerCase();
        }
        if (description != null && !description.isBlank()){
            description = description.trim().toLowerCase();
        }

        if (name != null){
            spc = spc.and(ProductSpecification.hasName(name));
        }

        if (description != null){
            spc = spc.and(ProductSpecification.hasDescription(description));
        }

        if (price != null){
            spc = spc.and(ProductSpecification.hasPrice(price));
        }

        return productRepository.findAll((Sort) spc)
                .stream()
                .map(this::forDTO)
                .toList();

    }


    public ProductResponseDTO updateProduct(Long id, ProductCreateDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());

        Product updated = productRepository.save(product);

        return forDTO(updated);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        productRepository.delete(product);
    }

}
