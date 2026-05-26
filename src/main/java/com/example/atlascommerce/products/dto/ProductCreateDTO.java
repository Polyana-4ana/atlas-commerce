package com.example.atlascommerce.products.dto;


import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class ProductCreateDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "A descrição é obrigatória")
    private String description;

    @NotBlank(message = "O preço é obrigatório")
    private BigDecimal price;

    public Long getId(){
        return  id;
    }

    public void setId(Long id){this.id = id;}

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}

    public BigDecimal getPrice(){return price;}

    public void setPrice(BigDecimal price){this.price = price;}
}

