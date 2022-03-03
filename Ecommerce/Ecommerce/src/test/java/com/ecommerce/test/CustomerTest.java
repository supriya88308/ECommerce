package com.digia_coding.test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.ecommerce.datarepository.CustomerRepository;
import com.ecommerce.exception.CustomerNotFoundException;
import com.ecommerce.model.Customer;

@SpringBootTest
class CustomerdataApplicationTests extends CodingTestApplicationTests {

	@Autowired
	CustomerRepository customer_repo;

	@Test
	@Order(1)
	public void Create_Customer() {
		Customer customer = new Customer();
		customer.setIdcustomer(8);
		customer.setcustomer_name("ABC");
		customer.setAddress("XYZ");
		customer_repo.save(customer);

	}

	@Test
	@Order(2)
	public void List_AllCustomer() {
		List list = customer_repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public HttpStatus List_Customer_ById() {
		Customer customer = customer_repo.findById(1).get();
		assertEquals("Divya", customer.getcustomer_name());
		if (customer == null)
			throw new CustomerNotFoundException("Customer");
		return (HttpStatus.OK);
	}

	@Test
	@Order(4)
	public HttpStatus List_Customer_ById_NotFound() {
		Customer customer = customer_repo.findById(19).get();
		if (customer == null)
			throw new CustomerNotFoundException("Customer");
		return (HttpStatus.OK);
	}

	@Test
	@Order(5)
	public HttpStatus List_Customer_ByName_NotFound() {
		List<Customer> customer = customer_repo.findByCustomer_Name("Divya");
		if (customer.isEmpty())
			throw new CustomerNotFoundException("Customer");
		return (HttpStatus.OK);
	}

}