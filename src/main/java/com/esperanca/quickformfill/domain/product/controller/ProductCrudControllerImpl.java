package com.esperanca.quickformfill.domain.product.controller;

import com.esperanca.quickformfill.domain.product.dto.ProductInputDto;
import com.esperanca.quickformfill.domain.product.dto.ProductOutputDto;
import com.esperanca.quickformfill.domain.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductCrudControllerImpl implements ProductCrudController {

    private final ProductService service;

    @Override
    @GetMapping
    public List<ProductOutputDto> findAll() {
        return this.service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public ProductOutputDto findById(@PathVariable() Long id) {
        return this.service.findById(id);
    }

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public ProductOutputDto save(@RequestBody ProductInputDto productInputDto) {
        return this.service.save(productInputDto);
    }

    @Override
    @PutMapping("/{id}")
    public ProductOutputDto updateById(@PathVariable Long id, @RequestBody ProductInputDto productInputDto) {
        return this.service.updateById(id, productInputDto);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        this.service.deleteById(id);
    }
}
