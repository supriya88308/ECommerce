package com.ecommerce.service;
 
import java.util.List;


import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.datarepository.CustomerRepository;
import com.ecommerce.exception.CustomerNotFoundException;
import com.ecommerce.model.Customer;

 
@Service
@Transactional
public class CustomerService {
 
    @Autowired
    private CustomerRepository customer_repo;
     
    public List<Customer> listAll() {
        return customer_repo.findAll();
    }
     
    public void save(Customer customer) {
    	customer_repo.save(customer);
    }
     
	
	  public List<Customer> getCustomerName(String customer_name) throws CustomerNotFoundException { return
			  customer_repo.findByCustomer_Name(customer_name); }
	 
     
}