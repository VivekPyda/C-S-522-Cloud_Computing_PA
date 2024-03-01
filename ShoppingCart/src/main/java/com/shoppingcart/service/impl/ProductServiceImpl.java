package com.shoppingcart.service.impl;

import java.util.List;

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
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);
	}

}
