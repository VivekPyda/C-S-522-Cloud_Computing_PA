package com.shoppingcart.service.impl;

import org.springframework.stereotype.Service;

import com.shoppingcart.entity.ProductBought;
import com.shoppingcart.repository.ProductBoughtRepository;
import com.shoppingcart.repository.ProductRepository;
import com.shoppingcart.service.ProductBoughtService;
import com.shoppingcart.service.ProductService;

@Service
public class ProductBoughtServiceImpl implements ProductBoughtService {

	private final ProductBoughtRepository productBoughtRepository;

	private final ProductService productService;

	public ProductBoughtServiceImpl(ProductBoughtRepository productBoughtRepository, ProductService productService) {
		this.productBoughtRepository = productBoughtRepository;
		this.productService = productService;
	}

	@Override
	public void processPurchase(ProductBought productBought) {
		productBoughtRepository.save(productBought);
		productService.updateInventoryCount(productBought.getProductBoughtID().getProductID(),
				productBought.getQuantity());
	}
}
