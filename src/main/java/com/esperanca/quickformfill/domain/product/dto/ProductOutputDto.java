package com.esperanca.quickformfill.domain.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductOutputDto {

    private Long id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Integer amount;
    private String supplier;
    private String brand;
}
