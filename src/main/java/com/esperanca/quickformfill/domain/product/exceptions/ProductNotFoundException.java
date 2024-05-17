package com.esperanca.quickformfill.domain.product.exceptions;

import com.esperanca.quickformfill.core.exceptions.base.EntityNotFoundException;

public class ProductNotFoundException extends EntityNotFoundException {
    private static final String STATE_NOT_FOUND =
            "Product not found with ID: %d";

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(Long id) {
        this(String.format(STATE_NOT_FOUND, id));
    }
}
