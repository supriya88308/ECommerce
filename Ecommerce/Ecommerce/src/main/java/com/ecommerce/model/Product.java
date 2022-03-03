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
@NamedQuery(name = "Product.findByProduct_name", query = "SELECT p FROM Product p WHERE LOWER(p.product_name) = LOWER(?1)")
@Table(name = "products", catalog = "test_digiadb")
public class Product {

	private Integer idproduct;
	private String product_name;
	private double unit_price;

	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Purchase> purchase = new HashSet<>();

	public Product() {
	}

	public Product(Integer idproduct, double unit_price, String product_name) {
		this.idproduct = idproduct;
		this.unit_price = unit_price;
		this.product_name = product_name;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idproduct", unique = true, nullable = false)
	public Integer getIdProduct() {
		return this.idproduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idproduct = idProduct;
	}

	@Column(name = "product_name")
	public String getproduct_name() {
		return this.product_name;
	}

	public void setproduct_name(String product_name) {
		this.product_name = product_name;
	}

	@Column(name = "unit_price")
	public double getUnitPrice() {
		return this.unit_price;
	}

	public void setUnitPrice(double unit_price) {
		this.unit_price = unit_price;
	}

}