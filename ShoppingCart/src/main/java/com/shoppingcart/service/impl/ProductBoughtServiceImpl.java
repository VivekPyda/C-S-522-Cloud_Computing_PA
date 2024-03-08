package com.shoppingcart.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingcart.entity.ProductBought;
import com.shoppingcart.entity.ProductBoughtID;
import com.shoppingcart.repository.ProductBoughtRepository;
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
	public List<ProductBought> getAllPurchases() {
		return productBoughtRepository.findAll();
	}

	@Override
	public void processPurchase(ProductBought productBought) {
		productBoughtRepository.save(productBought);
		productService.updateInventoryCount(productBought.getProductBoughtID().getProductID(),
				productBought.getQuantity());
	}

	@Override
	public void deletePurchaseById(Integer productID, Integer userID) {
		// Get the product details for this entry and the quantity back to the product table
		
		ProductBoughtID productBoughtID = new ProductBoughtID();
		productBoughtID.setProductID(productID);
		productBoughtID.setUserID(userID);
		productBoughtRepository.deleteById(productBoughtID);
		
		
	}

}
