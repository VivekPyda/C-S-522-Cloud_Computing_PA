package com.shoppingcart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shoppingcart.entity.Product;
import com.shoppingcart.repository.ProductRepository;
import com.shoppingcart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findByInventoryCountGreaterThan(int quantity) {
		return productRepository.findByInventoryCountGreaterThan(quantity);
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);
	}

	@Override
	public void updateInventoryCount(Integer productId, int quantity) {
		Product product = productRepository.findById(productId).get();
		int currentInventory = product.getInventoryCount();
		int updatedInventory = Math.max(currentInventory - quantity, 0);
		product.setInventoryCount(updatedInventory);
		productRepository.save(product);
	}
}
