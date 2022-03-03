package com.ecommerce.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import com.ecommerce.exception.CustomerNotFoundException;
import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.model.Purchase;
import com.ecommerce.service.PurchaseService;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseController.class);

	@Autowired
	private PurchaseService purchase_service;

	@PostMapping("/createpurchase")
	public String add(@RequestBody Purchase purchase) {
		purchase_service.save(purchase);
		LOGGER.info("Purchase created successfully");
		return "Purchase created successfully";
	}

	@GetMapping("/listpurchase")
	public List<Purchase> list() {
		LOGGER.info("Purchases listed successfully");
		return purchase_service.listAll();
	}

	@GetMapping("/listpurchase/customers/{customer_id}")
	public ResponseEntity<Page<Purchase>> getPurchaseByCustomer(@PathVariable Integer customer_id)
			throws CustomerNotFoundException {
		Page<Purchase> purchase = purchase_service.getPurchaseByCustomer(customer_id);
		LOGGER.info("Purchases per Customer listed successfully");
		if (purchase.getTotalElements() == 0)
			throw new CustomerNotFoundException(customer_id.toString());
			LOGGER.info("Purchases per Customer Not found-404");
		return new ResponseEntity<Page<Purchase>>(purchase, HttpStatus.OK);

	}

	@GetMapping("/listpurchase/products/{product_id}")
	public ResponseEntity<Page<Purchase>> getPurchaseByProduct(@PathVariable Integer product_id)
			throws ProductNotFoundException {
		LOGGER.info("Purchases per Product listed successfully");
		Page<Purchase> purchase = purchase_service.getPurchaseByProduct(product_id);
		if (purchase.getTotalElements() == 0)
			throw new ProductNotFoundException(product_id.toString());
			LOGGER.info("Purchases per Product Not found-404");
		return new ResponseEntity<Page<Purchase>>(purchase, HttpStatus.OK);

	}

}