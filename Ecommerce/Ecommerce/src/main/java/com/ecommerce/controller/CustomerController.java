package com.ecommerce.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.exception.CustomerNotFoundException;
import com.ecommerce.model.Customer;
import com.ecommerce.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customer_service;

	@PostMapping("/createcustomer")
	public String add(@RequestBody Customer customer) {
		customer_service.save(customer);
		LOGGER.info("Customer created successfully");
		return "Customer created successfully";
	}

	@GetMapping("/listcustomers")
	public List<Customer> list() {
		LOGGER.info("Customers listed successfully");
		return customer_service.listAll();
	}

	@GetMapping("/listcustomers/{customer_name}")
	public ResponseEntity<List<Customer>> getCustomerName(@PathVariable String customer_name)
			throws CustomerNotFoundException {
		List<Customer> customer = customer_service.getCustomerName(customer_name);
		if (customer.isEmpty())
			throw new CustomerNotFoundException(customer_name);
		LOGGER.info("Customer details fetched successfully");
		return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);

	}

}