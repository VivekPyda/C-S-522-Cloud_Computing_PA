package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.entity.Product;

public interface ProductService {
	List<Product> getAllProducts();
	
	List<Product> findByInventoryCountGreaterThan(int quantity);

	Product saveProduct(Product product);
	
	void deleteProductById(Integer id);

	void updateInventoryCount(Integer productId, int quantity);
}
