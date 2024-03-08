package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.entity.ProductBought;
import com.shoppingcart.entity.ProductBoughtID;

public interface ProductBoughtService {
	
	List<ProductBought> getAllPurchases();
 
	void processPurchase(ProductBought productBought);

	void deletePurchaseById(Integer productID, Integer userID);

}
