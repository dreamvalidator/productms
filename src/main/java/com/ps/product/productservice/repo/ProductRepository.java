package com.ps.product.productservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.product.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
