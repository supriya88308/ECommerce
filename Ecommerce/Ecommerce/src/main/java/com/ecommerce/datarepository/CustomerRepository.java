package com.ecommerce.datarepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public List<Customer> findByCustomer_Name(String customer_name);

}