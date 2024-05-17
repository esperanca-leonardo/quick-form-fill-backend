package com.esperanca.quickformfill.domain.product.assemblers.entity;

import com.esperanca.quickformfill.domain.product.dto.ProductInputDto;
import com.esperanca.quickformfill.domain.product.entities.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductEntityAssemblerImpl implements ProductEntityAssembler {

    private final ModelMapper modelMapper;

    @Override
    public Product toEntity(ProductInputDto productInputDto) {
        return this.modelMapper.map(productInputDto, Product.class);
    }
}
