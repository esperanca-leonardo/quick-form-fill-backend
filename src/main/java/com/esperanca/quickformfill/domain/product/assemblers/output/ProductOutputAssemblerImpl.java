package com.esperanca.quickformfill.domain.product.assemblers.output;

import com.esperanca.quickformfill.domain.product.dto.ProductOutputDto;
import com.esperanca.quickformfill.domain.product.entities.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductOutputAssemblerImpl implements ProductOutputAssembler {

    private final ModelMapper modelMapper;

    @Override
    public ProductOutputDto toOutput(Product product) {
        return this.modelMapper.map(product, ProductOutputDto.class);
    }

    @Override
    public List<ProductOutputDto> toCollectionOutput(List<Product> products) {
        return products.stream()
                .map(this::toOutput)
                .toList();
    }
}
