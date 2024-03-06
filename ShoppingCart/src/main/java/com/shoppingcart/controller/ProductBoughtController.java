package com.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shoppingcart.entity.ProductBought;
import com.shoppingcart.service.ProductBoughtService;
import com.shoppingcart.service.ProductService;
import com.shoppingcart.service.UserService;

@Controller
public class ProductBoughtController {

    private final ProductBoughtService productBoughtService;
    private final UserService userService;
    private final ProductService productService;

    public ProductBoughtController(ProductBoughtService productBoughtService, UserService userService, ProductService productService) {
        this.productBoughtService = productBoughtService;
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String showPurchaseForm(Model model) {
        // Populate model attributes needed for the form
        model.addAttribute("productBought", new ProductBought());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("products", productService.getAllProducts());
        return "purchase";
    }

    @PostMapping("/processPurchase")
    public String processPurchase(@ModelAttribute ProductBought productBought, Model model) {
    	productBoughtService.processPurchase(productBought);
        return "redirect:/";
    }
}
