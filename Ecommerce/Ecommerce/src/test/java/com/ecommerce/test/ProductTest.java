package com.digia_coding.test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.ecommerce.datarepository.ProductRepository;
import com.ecommerce.exception.CustomerNotFoundException;
import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.model.Product;

@SpringBootTest
class ProductdataApplicationTests extends CodingTestApplicationTests {

	@Autowired
	ProductRepository product_repo;

	@Test
	@Order(1)
	public void Create_Product() {
		Product product = new Product();
		product.setIdProduct(1);
		product.setproduct_name("iPhone");
		product.setUnitPrice(1000.00);
		product_repo.save(product);

	}

	@Test
	@Order(2)
	public void List_AllProducts() {
		List list = product_repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void List_Product_ById() {
		Product product = product_repo.findById(1).get();
		assertEquals("iPhone", product.getproduct_name());
	}

	@Test
	@Order(4)
	public void List_Product_ByName() {
		Product product = product_repo.findByProduct_name("iPhone");
		assertEquals(1, product.getIdProduct());
	}

	@Test
	@Order(5)
	public HttpStatus List_Product_ByName_Not_Found() {
		Product product = product_repo.findByProduct_name("iPhon");
		if (product == null)
			throw new ProductNotFoundException("Product");
		return (HttpStatus.OK);
	}

}