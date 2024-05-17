package com.esperanca.quickformfill.domain.product.assemblers.entity;

import com.esperanca.quickformfill.core.assemblers.EntityAssembler;
import com.esperanca.quickformfill.domain.product.dto.ProductInputDto;
import com.esperanca.quickformfill.domain.product.entities.Product;

public interface ProductEntityAssembler extends EntityAssembler<Product, ProductInputDto> {

    @Override
    Product toEntity(ProductInputDto productInputDto);
}
