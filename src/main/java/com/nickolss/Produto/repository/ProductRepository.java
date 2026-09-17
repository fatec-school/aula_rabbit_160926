package com.nickolss.Produto.repository;

import com.nickolss.Produto.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
