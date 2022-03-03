package com.ecommerce.datarepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Product findByProduct_name(String product_name);

}