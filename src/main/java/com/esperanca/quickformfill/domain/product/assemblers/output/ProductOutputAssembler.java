package com.esperanca.quickformfill.domain.product.assemblers.output;

import com.esperanca.quickformfill.core.assemblers.OutputAssembler;
import com.esperanca.quickformfill.domain.product.dto.ProductOutputDto;
import com.esperanca.quickformfill.domain.product.entities.Product;

import java.util.List;

public interface ProductOutputAssembler extends OutputAssembler<Product, ProductOutputDto> {

    @Override
    ProductOutputDto toOutput(Product product);

    @Override
    List<ProductOutputDto> toCollectionOutput(List<Product> products);
}
