package com.sportyshoes.Service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sportyshoes.entity.Order;
import com.sportyshoes.entity.Product;

@Service
public interface OrderService {

	public Order createOrder(Order order);
	public List<Order> getAllOrder();
	public Order findByOrderId(long orderid);

	
}
