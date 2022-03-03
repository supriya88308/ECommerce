package com.ecommerce.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService product_service;

	@PostMapping("/createproduct")
	public String add(@RequestBody Product products) {
		product_service.save(products);
		LOGGER.info("Product created successfully");
		return "Product created successfully";
	}

	@GetMapping("/listproducts")
	public List<Product> list() {
		LOGGER.info("Products listed successfully");
		return product_service.listAll();
	}

	@GetMapping("/listproducts/{product_name}")
	public ResponseEntity<Product> getProduct(@PathVariable String product_name) throws ProductNotFoundException {
		Product products = product_service.getProduct(product_name);
		if (products == null)
			throw new ProductNotFoundException(product_name);
		LOGGER.info("Product details fetched successfully");
		return new ResponseEntity<Product>(products, HttpStatus.OK);
	}

}