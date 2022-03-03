package com.digia_coding.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ecommerce.datarepository.PurchaseRepository;
import com.ecommerce.exception.CustomerNotFoundException;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;
import com.ecommerce.model.Purchase;

@SpringBootTest
class PurchasedataApplicationTests extends CodingTestApplicationTests {

	@Autowired
	PurchaseRepository purchase_repo;

	@Test

	@Order(1)
	public void Create_Purchase() {

		Purchase purchase = new Purchase();
		Customer customers = new Customer();
		Product products = new Product();

		customers.setIdcustomer(1);
		customers.setcustomer_name("ABC");
		customers.setAddress("XYZ");

		products.setIdProduct(1);
		products.setproduct_name("iPhone");
		products.setUnitPrice(1000.00);

		purchase.setIdPurchase(1);
		purchase.setCustomer(customers);
		purchase.setProduct(products);

		purchase_repo.save(purchase);

	}

	@Test
	@Order(2)
	public void List_AllPurchases() {
		List list = purchase_repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void List_Purchase_Per_Customer() {
		Page<Purchase> purchase = purchase_repo.FindPurchasePerCustomer(1, null);
	}

	@Test

	@Order(4)
	public void List_Purchase_Per_Product() {
		Page<Purchase> purchase = purchase_repo.FindPurchasePerProduct(1, null);
	}

	@Test
	@Order(5)
	public void List_Purchase_Per_Customer_Not_Found() throws CustomerNotFoundException {
		Page<Purchase> purchase = purchase_repo.FindPurchasePerCustomer(10, null);
	}

}