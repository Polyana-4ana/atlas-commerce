package com.example.atlascommerce.products.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class ProductCreateDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "A descrição é obrigatória")
    private String description;

    @NotNull(message="Preço obrigatório")
    @Positive(message="Preço deve ser positivo")
    private BigDecimal price;

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}

    public BigDecimal getPrice(){return price;}

    public void setPrice(BigDecimal price){this.price = price;}
}

