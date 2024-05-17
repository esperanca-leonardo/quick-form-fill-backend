package com.esperanca.quickformfill.domain.product.service;

import com.esperanca.quickformfill.core.utils.propertycopier.PropertyCopier;
import com.esperanca.quickformfill.domain.product.assemblers.entity.ProductEntityAssembler;
import com.esperanca.quickformfill.domain.product.assemblers.output.ProductOutputAssembler;
import com.esperanca.quickformfill.domain.product.dto.ProductInputDto;
import com.esperanca.quickformfill.domain.product.dto.ProductOutputDto;
import com.esperanca.quickformfill.domain.product.entities.Product;
import com.esperanca.quickformfill.domain.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    private final PropertyCopier propertyCopier;

    private final ProductOutputAssembler outputAssembler;

    private final ProductEntityAssembler entityAssembler;


    @Override
    @Transactional(readOnly = true)
    public List<ProductOutputDto> findAll() {
        final List<Product> products = this.repository.findAll();
        return this.outputAssembler.toCollectionOutput(products);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductOutputDto findById(Long id) {
        return this.repository.findById(id)
                .map(this.outputAssembler::toOutput)
                .get();
    }

    @Override
    @Transactional
    public ProductOutputDto save(ProductInputDto productInputDto) {
        Product product = this.entityAssembler.toEntity(productInputDto);
        product = this.repository.save(product);
        return this.outputAssembler.toOutput(product);
    }

    @Override
    @Transactional
    public ProductOutputDto updateById(Long id, ProductInputDto productInputDto) {
        Product product = this.repository.findById(id).get();
        this.propertyCopier.copyProperties(productInputDto, product);
        product = this.repository.save(product);
        return this.outputAssembler.toOutput(product);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}
