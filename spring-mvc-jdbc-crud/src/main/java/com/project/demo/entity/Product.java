package com.project.demo.entity;

public class Product {

	private Integer productId;
	private String productName;
	private String companyName;
	private Double price;

	public Product() {

	}

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
