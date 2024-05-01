package com.project.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.demo.dao.ProductDao;
import com.project.demo.entity.Product;

@Repository("usingJdbc")
public class ProductDaoImplJdbcTemplate implements ProductDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveOrUpdate(Product productDTO) {
		if(productDTO.getProductId() == null) {
			
			String query = "insert into tbl_product(product_name,company_name,price) values(?,?,?)";
			int rows = jdbcTemplate.update(query, productDTO.getProductName(), productDTO.getCompanyName(),
					productDTO.getPrice());
			
			if(rows>0) {
				System.out.println("Record has been saved successfully....");
				//getProducts();
				//getProducts2();
			}else {
				System.out.println("Something went wrong to insert record...");
			}
		}else {
			
			String query = "update tbl_product set product_name=?, company_name=?,"
					+ "price=? where product_id=?";
			int rows = jdbcTemplate.update(query,productDTO.getProductName(), productDTO.getCompanyName(), 
					productDTO.getPrice(), productDTO.getProductId() );
			
			if(rows>0) {
				System.out.println("Record has been updated successfully....");
			}else {
				System.out.println("Something went wrong to update record...");
			}
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from tbl_product where product_id=?";
		int rows = jdbcTemplate.update(sql,id);
		if(rows>0) {
			System.out.println("Record has been deleted successfully....");
		}else {
			System.out.println("Something went wrong to delete record...");
		}
		
	}
	
	@Override
	public Product get(int id) {
		String query = "select * from tbl_product where product_id=?";
		Product product = jdbcTemplate.queryForObject(query, new Object[] {id}, 
				new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setCompanyName(rs.getString("company_name"));
				product.setPrice(rs.getDouble("price"));
				System.out.println("Fetched Record: "+product);
				return product;
			}
			
		});
		
		if(product.getProductId()>0) {
			System.out.println("Record has been fetched successfully\n");
		}else {
			System.out.println("Something went wrong to delete record...");
		}
		return product;
	}

//	@Override
//	public ProductDTO get(int id) {
//		String query = "select * from tbl_product where product_id=?";
//		int rows = jdbcTemplate.update(query, id, new ResultSetExtractor<ProductDTO>() {
//
//			@Override
//			public ProductDTO extractData(ResultSet rs) throws SQLException, DataAccessException {
//				ProductDTO product = new ProductDTO();
//				product.setProductId(rs.getInt("product_id"));
//				product.setTitle(rs.getString("product_title"));
//				product.setCompanyName(rs.getString("company_name"));
//				product.setPrice(rs.getDouble("price"));
//				System.out.println("Fetched Record: "+product);
//				return product;
//			}
//		});
//		
//		if(rows>0) {
//			System.out.println("Record has been fetched successfully\n");
//		}else {
//			System.out.println("Something went wrong to delete record...");
//		}
//		return null;
//	}

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
//		for(ProductDTO product: list) {
//			System.out.println(product);
//		}
		return list;
	}
	
	public List<Product> getProducts2() {
		
		String sql = "SELECT * FROM tbl_product";	     
		List<Product> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
		for(Product product: list) {
			System.out.println(product);
		}
	    return list;  
	}

}
