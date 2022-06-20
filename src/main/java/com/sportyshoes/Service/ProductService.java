package com.sportyshoes.Service;

import java.util.List;

import com.sportyshoes.entity.Product;


public interface ProductService {
	public Product createProduct(Product product);
	public List<Product> getAllProduct();
	public void deleteByProductId(long productId);
	public Product findByProductId(long productId);
	public Product updateProduct(Product product);
	public List<Product> findByCategory(String category);
	public List<Product> findByBrand(String brand);
}
