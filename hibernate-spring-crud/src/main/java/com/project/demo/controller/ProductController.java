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
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/add-product")
	public String landingProductPage(@ModelAttribute("productDTO") Product product ) {
		return "product-page";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addOrModifyProductDetails(@ModelAttribute("productDTO") Product product ) {
		if(product != null) {
			productDao.addOrModifyProduct(product);
		}
		return "redirect:/product/find-all-products";
	}
	
	@RequestMapping("/find-all-products")
	public ModelAndView getProducts() {
		List<Product> products = productDao.getProducts();
		for(Product product : products) {
			System.out.println(product);
		}
		ModelAndView view = new ModelAndView();
		view.addObject("productList", products);
		view.setViewName("all-products");
		return view;
	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView updateProduct(@RequestParam Integer id) {
		if(id != null) {
			Product product = productDao.getProduct(id);
			ModelAndView view = new ModelAndView();
			view.addObject("productDTO",product);
			view.setViewName("product-page");
			return view;
		}
		return null;
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public String removeProduct(@RequestParam Integer id) {
		System.out.println("product_id = =========== "+id);
		productDao.deleteProduct(id);
		return "redirect:/product/find-all-products";
	}
}
