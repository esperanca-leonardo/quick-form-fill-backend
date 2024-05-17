package com.esperanca.quickformfill.domain.product.controller;

import com.esperanca.quickformfill.domain.product.dto.ProductInputDto;
import com.esperanca.quickformfill.domain.product.dto.ProductOutputDto;

import java.util.List;

public interface ProductCrudController {

    List<ProductOutputDto> findAll();
    ProductOutputDto findById(Long id);
    ProductOutputDto save(ProductInputDto productInputDto);
    ProductOutputDto updateById(Long id, ProductInputDto productInputDto);
    void deleteById(Long id);
}
