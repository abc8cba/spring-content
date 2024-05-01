package com.project.demo.dao;

import java.util.List;

import com.project.demo.entity.Product;

public interface ProductDao {
	
	void addOrModifyProduct(Product product);
	
	void deleteProduct(Integer id);
	
	Product getProduct(Integer id);
	
	List<Product> getProducts();

}
