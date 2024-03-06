package com.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.entity.ProductBought;
import com.shoppingcart.entity.ProductBoughtID;

public interface ProductBoughtRepository extends JpaRepository<ProductBought, ProductBoughtID> {

}
