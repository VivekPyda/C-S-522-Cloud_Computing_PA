package com.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByInventoryCountGreaterThan(int quantity);
}
