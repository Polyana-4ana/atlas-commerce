package com.example.atlascommerce.products.service;

import com.example.atlascommerce.products.domain.Product;
import com.example.atlascommerce.products.dto.ProductCreateDTO;
import com.example.atlascommerce.products.dto.ProductResponseDTO;
import com.example.atlascommerce.products.repository.ProductRepository;
import com.example.atlascommerce.products.repository.ProductSpecification;
import com.example.atlascommerce.shared.exception.ResourceNotFoundException;
import com.example.atlascommerce.products.mapper.ProductMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponseDTO createProduct(ProductCreateDTO dto){

        Product product = productMapper.toEntity(dto);

        Product saved = productRepository.save(product);

        return productMapper.toResponse(saved);
    }

    public List<ProductResponseDTO> findAll(){
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    public ProductResponseDTO findById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found" + id));

        return productMapper.toResponse(product);
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

        return productRepository.findAll(spc)
                .stream()
                .map(productMapper::toResponse)
                .toList();

    }


    public ProductResponseDTO updateProduct(Long id, ProductCreateDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());

        Product updated = productRepository.save(product);

        return productMapper.toResponse(updated);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        productRepository.delete(product);
    }

}
