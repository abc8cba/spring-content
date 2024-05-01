package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.demo.dao.ProductDao;
import com.project.demo.entity.Product;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String getHomepage() {
		return "home";
	}
	
	@RequestMapping(value = "/getproduct")
	public String getProductPage(@ModelAttribute("product") Product product) {
		return "save-product";
	}
	
	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String saveOrUpdateProduct(@ModelAttribute("product") Product product) {
		System.out.println(product);
		if(product != null) {
			productDao.addOrModifyProduct(product);
		}else {
			System.out.println("Product object is null so can not be inserted in database..");
		}
		return "redirect:/get-all-products";
	}
	
	@RequestMapping(value = "get-all-products", method = RequestMethod.GET)
	public ModelAndView getAllProduct() {
		List<Product> products = productDao.getProducts();
		for(Product product: products) {
			System.out.println(product);
		}
		ModelAndView view = new ModelAndView();
		view.addObject("productList", products);
		view.setViewName("all-products");		
		return view;
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public String removeProduct(@RequestParam("id") Integer productId) {
		System.out.println("product_id = =========== "+productId);
		productDao.deleteProduct(productId);
		return "redirect:/get-all-products";
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
