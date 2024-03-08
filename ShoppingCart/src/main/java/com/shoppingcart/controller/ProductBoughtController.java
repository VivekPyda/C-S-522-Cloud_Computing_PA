package com.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shoppingcart.entity.ProductBought;
import com.shoppingcart.entity.ProductBoughtID;
import com.shoppingcart.service.ProductBoughtService;
import com.shoppingcart.service.ProductService;
import com.shoppingcart.service.UserService;

@Controller
public class ProductBoughtController {

	private final ProductBoughtService productBoughtService;
	private final UserService userService;
	private final ProductService productService;

	public ProductBoughtController(ProductBoughtService productBoughtService, UserService userService,
			ProductService productService) {
		this.productBoughtService = productBoughtService;
		this.userService = userService;
		this.productService = productService;
	}

	@GetMapping("/")
	public String listProducts(Model model) {
		model.addAttribute("productsBought", productBoughtService.getAllPurchases());
		return "purchase_list";
	}

	@GetMapping("/cutomerPurchases/new")
	public String showPurchaseForm(Model model) {
		// Populate model attributes needed for the form
		model.addAttribute("productBought", new ProductBought());
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("products", productService.findByInventoryCountGreaterThan(0));
		return "purchase";
	}

	@PostMapping("/processPurchase")
	public String processPurchase(@ModelAttribute ProductBought productBought, Model model) {
		productBoughtService.processPurchase(productBought);
		return "redirect:/";
	}

	@GetMapping("/customerPurchases/delete/{productID}/{userID}")
	public String deletePurchase(@PathVariable("productID") Integer productID, @PathVariable("userID") Integer userID) {
		productBoughtService.deletePurchaseById(productID, userID);
		return "redirect:/";
	}

}
