package com.sportyshoes.Repository;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
