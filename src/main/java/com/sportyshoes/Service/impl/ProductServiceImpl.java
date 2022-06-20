package com.sportyshoes.Service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.Repository.ProductRepository;
import com.sportyshoes.Service.ProductService;
import com.sportyshoes.entity.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	@Transactional
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteByProductId(long productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
	}

	@Override
	@Transactional
	public Product findByProductId(long productId) {
		// TODO Auto-generated method stub
		return productRepository.findByProductId(productId);
	}

	@Override
	@Transactional

	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	@Transactional
	public List<Product> findByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(category);
	}

	@Override
	@Transactional
	public List<Product> findByBrand(String brand) {
		// TODO Auto-generated method stub
		return productRepository.findByBrand(brand);
	}

	
}
