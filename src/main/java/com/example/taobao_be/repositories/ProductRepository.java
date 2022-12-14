package com.example.taobao_be.repositories;

import com.example.taobao_be.models.Category;
import com.example.taobao_be.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findProductsByCategory(Category category, Pageable pageable);
}
