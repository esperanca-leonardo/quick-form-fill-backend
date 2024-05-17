package com.esperanca.quickformfill.domain.product.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductInputDto {

    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Integer amount;
    private String supplier;
    private String brand;
}
