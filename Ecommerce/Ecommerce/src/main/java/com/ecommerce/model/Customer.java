package com.ecommerce.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Customer.findByCustomer_Name", query = "SELECT c FROM Customer c WHERE LOWER(c.customer_name) = LOWER(?1)")
@Table(name = "customers", catalog = "test_digiadb")
public class Customer {

	private Integer idcustomer;
	private String customer_name;
	private String address;

	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Purchase> purchase = new HashSet<>();

	public Customer() {
	}

	public Customer(Integer idcustomer, String customer_name, String address) {
		this.idcustomer = idcustomer;
		this.customer_name = customer_name;
		this.address = address;

	}

	// getters and setters
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcustomer", unique = true, nullable = false)
	public Integer getIdcustomer() {
		return this.idcustomer;
	}

	public void setIdcustomer(Integer idcustomer) {
		this.idcustomer = idcustomer;
	}

	@Column(name = "customer_name")
	public String getcustomer_name() {
		return customer_name;
	}

	public void setcustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}