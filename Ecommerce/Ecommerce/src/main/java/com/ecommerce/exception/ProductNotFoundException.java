package com.ecommerce.exception;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

import ch.qos.logback.classic.Logger;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Product found")
public class ProductNotFoundException extends RuntimeException {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductNotFoundException.class);
	
	public ProductNotFoundException(String exception) {
		super(exception);
		
		LOGGER.error("Customer Not Found");
	}

}