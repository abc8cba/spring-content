package com.project.demo.dao;

import java.util.List;

import com.project.demo.entity.Product;

public interface ProductDao {
	
	public void saveOrUpdate(Product productDTO);
    
    public void delete(int id);
     
    public Product get(int id);
     
    public List<Product> getProducts();

}
