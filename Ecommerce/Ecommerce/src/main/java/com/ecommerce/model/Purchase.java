package com.ecommerce.model;

import static javax.persistence.GenerationType.IDENTITY;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase", catalog = "test_digiadb")
public class Purchase {

	private Integer idpurchase;

	@ManyToOne
	@JoinColumn(name = "idcustomer")
	private Customer customers;

	@ManyToOne
	@JoinColumn(name = "idproduct")
	private Product products;

	private Date purchased_date;

	public Purchase() {
	}

	public Purchase(Integer idpurchase, Customer customers, Product products, Date purchased_date) {
		this.idpurchase = idpurchase;
		this.customers = customers;
		this.products = products;
		this.purchased_date = purchased_date;

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idpurchase", unique = true, nullable = false)
	public Integer getIdPurchase() {
		return this.idpurchase;
	}

	public void setIdPurchase(Integer idpurchase) {
		this.idpurchase = idpurchase;
	}

	@ManyToOne
	@JoinColumn(name = "idcustomer")
	public Customer getCustomer() {
		return this.customers;
	}

	public void setCustomer(Customer customers) {
		this.customers = customers;
	}

	@ManyToOne
	@JoinColumn(name = "idproduct")
	public Product getProduct() {
		return this.products;
	}

	public void setProduct(Product products) {
		this.products = products;
	}


	@Column(name = "purchased_date")
	public Date getPurchasedDate() {
		return this.purchased_date;
	}

	public void setPurchasedDate(Date purchased_date) {
		this.purchased_date = purchased_date;
	}

}