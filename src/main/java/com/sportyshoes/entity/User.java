package com.sportyshoes.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userid;
	private String username;
	private String password;
	private String email;
	private String role;

	@OneToMany(mappedBy = "user") 
	private List<Order> orders;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(long userid, String username, String password, String email, String role, List<Order> orders) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.orders = orders;
	}


	public long getUserid() {
		return userid;
	}


	public void setUserid(long userid) {
		this.userid = userid;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", role=" + role + ", orders=" + orders + "]";
	}

	
	
}
