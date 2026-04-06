package com.ecommerce.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getProductsSortedByPrice();

    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> getExpensiveProducts(double price);

    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    List<Product> getProductsByCategoryJPQL(String category);
}