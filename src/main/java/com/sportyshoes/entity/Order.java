package com.sportyshoes.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderid;
	
	private String category;
	@CreationTimestamp
	private Date orderdate;
	@UpdateTimestamp
	private Date updateddate;
	private int totalQauntity;
	private BigDecimal totalPrice;
	@ManyToOne	
	@JoinColumn(name = "userid",referencedColumnName = "userid")
	private User user;
	@ManyToOne
	@JoinColumn(name = "productid", referencedColumnName = "productId")
	private Product product;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(long orderid, Date date, Date updateddate, int totalQauntity, BigDecimal totalPrice, User user, Product product) {
		super();
		this.orderid = orderid;
		this.orderdate = date;
		this.updateddate = updateddate;
		this.totalQauntity = totalQauntity;
		this.totalPrice = totalPrice;
		this.user = user;
		this.product = product;
	}
	

	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public Date getUpdateddate() {
		return updateddate;
	}
	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}
	public int getTotalQauntity() {
		return totalQauntity;
	}
	public void setTotalQauntity(int totalQauntity) {
		this.totalQauntity = totalQauntity;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", category=" + category + ", orderdate=" + orderdate + ", updateddate="
				+ updateddate + ", totalQauntity=" + totalQauntity + ", totalPrice=" + totalPrice + ", user=" + user
				+ ", product=" + product + "]";
	}
	
}
