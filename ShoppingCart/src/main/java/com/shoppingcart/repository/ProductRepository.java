package com.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}