package com.ecommerce.exception;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ecommerce.CodingTestApplication;

import ch.qos.logback.classic.Logger;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Customer found")
public class CustomerNotFoundException extends RuntimeException {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CustomerNotFoundException.class);
	public CustomerNotFoundException(String exception) {
		super(exception);
		
		LOGGER.error("Customer Not Found");
		
	}

}