package com.esperanca.quickformfill.domain.product.repository;

import com.esperanca.quickformfill.domain.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
