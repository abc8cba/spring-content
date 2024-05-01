package com.project.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.demo.dao.ProductDao;
import com.project.demo.entity.Product;

@Repository("usingJdbcTemplate")
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addOrModifyProduct(Product product) {
		if(product.getProductId()== null) {
			int rows = jdbcTemplate.update("insert into tbl_product(product_name,company_name,price) values(?,?,?)",
					product.getProductName(), 
					product.getCompanyName(),
					product.getPrice()
			);
			
			if(rows>0) {
				System.out.println("Data has been saved successfully");
			}else {
				System.out.println("Something went wrong to add record.");
			}
		}else {
			int rows = jdbcTemplate.update("update tbl_product set product_name=?,company_name=?,price=? where product_id=?",
					product.getProductName(), 
					product.getCompanyName(),
					product.getPrice(),
					product.getProductId()
			);
			
			if(rows>0) {
				System.out.println("Data has been updated successfully");
			}else {
				System.out.println("Something went wrong to update record.");
			}
		}

	}

	@Override
	public void deleteProduct(Integer id) {
		String sql = "delete from tbl_product where product_id=?";
		int rows = jdbcTemplate.update(sql,id);
		if(rows>0) {
			System.out.println("Record has been deleted successfully....");
		}else {
			System.out.println("Something went wrong to delete record...");
		}

	}

	@Override
	public Product getProduct(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<Product> getProducts() {
		List<Product> list = jdbcTemplate.query("select * from tbl_product", new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setCompanyName(rs.getString("company_name"));
				product.setPrice(rs.getDouble("price"));
				
				return product;
			}
		});
		return list;
	}

}
