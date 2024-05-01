package com.project.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "company_name", nullable = false)
	private String companyName;

	@Column(name = "price", scale = 10, precision = 2, length = 10)
	private Double price;

	public Product(Integer productId, String productName, String companyName, Double price) {
		this.productId = productId;
		this.productName = productName;
		this.companyName = companyName;
		this.price = price;
	}

	public Product(String productName, String companyName, Double price) {
		this.productName = productName;
		this.companyName = companyName;
		this.price = price;
	}

	public Product() {

	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", companyName=" + companyName
				+ ", price=" + price + "]";
	}

}
