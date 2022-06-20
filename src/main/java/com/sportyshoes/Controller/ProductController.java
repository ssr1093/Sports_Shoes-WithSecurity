package com.sportyshoes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.Exception.ResourceNotFoundException;
import com.sportyshoes.Repository.ProductRepository;
import com.sportyshoes.Service.ProductService;
import com.sportyshoes.entity.Product;

@RestController
//@RequestMapping("/")
//@CrossOrigin 

public class ProductController {

	@Autowired
	private ProductService productservice;
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/product/new") // admin only can use
	public Product createProduct(@RequestBody Product product) {
		
		return productservice.createProduct(product);
	}
//for users and admin
    @GetMapping("/product")
	public List<Product> getAllProducts() {
				return productservice.getAllProduct();
	}
    // only admin
    @DeleteMapping(value = "/product/{productid}")
    public void deleteByProductId(@PathVariable long productId) {
    	productservice.deleteByProductId(productId);
    }
    // for admin and users
    @GetMapping(value = "/product/{productid}")
    public Product findByProductId(@PathVariable(value = "productId") long productId) {
    	    	
    	return productservice.findByProductId(productId);
//    			   .orElseThrow(Exception::new);
    }
    //for admin
    @PutMapping("/product/{productid}")
    public ResponseEntity<Product> updateProduct(@PathVariable long productId ,
    		@RequestBody Product productdetails)throws ResourceNotFoundException
    {
    	Product updateproduct = productRepository.findByProductId(productId);
    	updateproduct.setProductname(productdetails.getProductname());
    	updateproduct.setBrand(productdetails.getBrand());
    	updateproduct.setCategory(productdetails.getCategory());
    	updateproduct.setPrice(productdetails.getPrice());
    	productRepository.save(updateproduct);
    	
    	return ResponseEntity.ok(updateproduct);
    }
    // for user and admin
    @GetMapping(value = "/products/{category}")
    public List<Product> findByProductCategory(@PathVariable String category) {
    	
    	return productservice.findByCategory(category);
    }
//    for admin , user
    @GetMapping(value = "/products/{brand}")
    public List<Product> findByProductBrand(@PathVariable String brand) {
    	
    	return productservice.findByBrand(brand);
}
}