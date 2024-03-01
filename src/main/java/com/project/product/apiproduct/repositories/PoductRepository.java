package com.project.product.apiproduct.repositories;

import com.project.product.apiproduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoductRepository  extends JpaRepository<Product,Long> { }
