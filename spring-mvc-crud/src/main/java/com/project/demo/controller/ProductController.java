package com.project.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	@Qualifier("usingJdbc")
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String homePage() {
		//return "redirect:products";
		return "home";
	}
	
	@RequestMapping(value = "/product-page", method = RequestMethod.GET)
	public String getProductPage(@ModelAttribute("productDTO") Product productDTO) {
		System.out.println("getProductPage() method called....");
		return "product";
	}
	
	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("productDTO") Product productDTO,BindingResult result) {
		if(result.hasErrors()) {		
			return "product";
		}
		System.out.println("addProduct() method called....");
		System.out.println(productDTO);
		productDao.saveOrUpdate(productDTO);
		return "redirect:products";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView getProducts() {
		List<Product> productList = productDao.getProducts();
		System.out.println(productList);
		ModelAndView model = new ModelAndView();
		model.addObject("productList", productList);
		model.setViewName("products");
		return model;
	}
	
	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView updateProduct(@RequestParam Integer id) {
		if(id != null) {
			Product product = productDao.get(id);
			ModelAndView view = new ModelAndView();
			view.addObject("productDTO",product);
			view.setViewName("product");
			return view;
		}
		return null;
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public String removeProduct(@RequestParam Integer id) {
		System.out.println("product_id = =========== "+id);
		productDao.delete(id);
		return "redirect:products";
	}

}
