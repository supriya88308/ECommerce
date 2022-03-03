package com.ecommerce.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.datarepository.ProductRepository;
import com.ecommerce.model.Product;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository product_repo;

	public List<Product> listAll() {
		return product_repo.findAll();
	}

	public void save(Product products) {
		product_repo.save(products);
	}

	
	  public Product getProduct(String product_name) { 
		  return product_repo.findByProduct_name(product_name);
		  }
	 

}