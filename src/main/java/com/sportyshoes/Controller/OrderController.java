package com.sportyshoes.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.Service.OrderService;
import com.sportyshoes.entity.Order;

@RestController


public class OrderController {

		@Autowired
		private OrderService orderService;

		// only user can purchase
		@PostMapping("/order")
		public Order createOrder(@RequestBody Order order) {

			return orderService.createOrder(order);
		}

		// only admin and user for only user purchase
		@GetMapping("/orders/list")
		public List<Order> getAllOrders() {

			return orderService.getAllOrder();
		}

		// user and admin
		@GetMapping(value = "/order/{orderid}")
		public Order findByOrderId(@PathVariable long orderid) {

			return orderService.findByOrderId(orderid);
		}

		
		
	}

