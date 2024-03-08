package com.shoppingcart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shoppingcart.entity.Product;
import com.shoppingcart.entity.ProductBought;
import com.shoppingcart.entity.ProductBoughtID;
import com.shoppingcart.entity.User;
import com.shoppingcart.repository.ProductBoughtRepository;
import com.shoppingcart.repository.ProductRepository;
import com.shoppingcart.repository.UserRepository;
import com.shoppingcart.service.ProductBoughtService;
import com.shoppingcart.service.ProductService;

@Service
public class ProductBoughtServiceImpl implements ProductBoughtService {

	private final ProductBoughtRepository productBoughtRepository;

	private final ProductRepository productRepository;

	private final UserRepository userRepository;

	private final ProductService productService;

	public ProductBoughtServiceImpl(ProductBoughtRepository productBoughtRepository,
			ProductRepository productRepository, UserRepository userRepository, ProductService productService) {
		this.productBoughtRepository = productBoughtRepository;
		this.productRepository = productRepository;
		this.userRepository = userRepository;
		this.productService = productService;
	}

	@Override
	public List<ProductBought> getAllPurchases() {
		return productBoughtRepository.findAll();
	}

	@Override
	public void processPurchase(ProductBought productBought) {
		Optional<ProductBought> optionalProductBought = productBoughtRepository
				.findById(productBought.getProductBoughtID());

		if (optionalProductBought.isPresent()) {
			ProductBought existingPurchaseEntry = optionalProductBought.get();
			productService.updateInventoryCount(productBought.getProductBoughtID().getProductID(),
					productBought.getQuantity() - existingPurchaseEntry.getQuantity());
		} else {
			productService.updateInventoryCount(productBought.getProductBoughtID().getProductID(),
					productBought.getQuantity());
		}

		Product product = productRepository.findById(productBought.getProductBoughtID().getProductID()).get();
		User user = userRepository.findById(productBought.getProductBoughtID().getUserID()).get();
		productBought.setProductName(product.getName());
		productBought.setUserName(user.getUserName());
		productBoughtRepository.save(productBought);

	}

	@Override
	public void deletePurchaseById(Integer productID, Integer userID) {

		ProductBoughtID productBoughtID = new ProductBoughtID();
		productBoughtID.setProductID(productID);
		productBoughtID.setUserID(userID);

		// Get the product details for this entry and the quantity back to the product
		// table
		Optional<Product> optionalProduct = productRepository.findById(productID);
		ProductBought productBought = productBoughtRepository.findById(productBoughtID).get();

		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			product.setInventoryCount(product.getInventoryCount() + productBought.getQuantity());
			productRepository.save(product);
		}

		productBoughtRepository.deleteById(productBoughtID);
	}

}
