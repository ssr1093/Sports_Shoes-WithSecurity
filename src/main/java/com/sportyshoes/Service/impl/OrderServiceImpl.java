package com.sportyshoes.Service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.Repository.OrderRepository;
import com.sportyshoes.Service.OrderService;
import com.sportyshoes.entity.Order;
import com.sportyshoes.entity.Product;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	@Transactional
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	@Transactional
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	@Transactional
	public Order findByOrderId(long orderid) {
		// TODO Auto-generated method stub
		return orderRepository.getById(orderid);
	}


}
