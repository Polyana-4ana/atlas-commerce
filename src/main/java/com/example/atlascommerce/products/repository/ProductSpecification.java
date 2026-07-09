package com.example.atlascommerce.products.repository;

import com.example.atlascommerce.products.domain.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpecification {

    public static Specification<Product> hasName(String name){
        return (root, query, cb) ->
                name == null ? null : cb.equal(root.get("name"), name);
    }

    public static Specification<Product> hasDescription(String description){
        return (root, query, cb) ->
                description == null ? null : cb.equal(root.get("description"), description);
    }

    public static Specification<Product> hasPrice(BigDecimal price){
        return (root, query, cb) ->
                price == null ? null : cb.equal(root.get("price"), price);
    }

}
