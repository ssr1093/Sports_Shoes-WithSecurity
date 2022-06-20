package com.sportyshoes.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


	public void deleteByProductId(long productId); 
	public Product findByProductId(long productId);
	public List<Product> findByCategory(String category);
	public List<Product> findByBrand(String brand);

}
