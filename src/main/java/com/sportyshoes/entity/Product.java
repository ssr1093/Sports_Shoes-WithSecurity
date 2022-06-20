package com.sportyshoes.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "productId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	@Column
	private String productname;
	@Column
	private String brand;
	@Column
	private String category;
	@Column
	private double price;
	
	@OneToMany(targetEntity = Order.class,mappedBy ="product")
	private List<Order> orders;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long productId, String productname, String brand, String category, double price,
			List<Order> orders) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.orders = orders;
	}



	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product [productname=" + productname + ", brand=" + brand + ", category=" + category + ", price="
				+ price + "]";
	}
	


	
	
	
	
		
	
}
