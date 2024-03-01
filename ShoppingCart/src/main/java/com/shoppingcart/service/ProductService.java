package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.entity.Product;

public interface ProductService {
	List<Product> getAllProducts();

	Product saveProduct(Product product);
	
	void deleteProductById(Long id);
}
