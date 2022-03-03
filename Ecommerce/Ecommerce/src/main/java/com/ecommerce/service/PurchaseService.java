
package com.ecommerce.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import com.ecommerce.datarepository.PurchaseRepository;
import com.ecommerce.model.Purchase;

@Service
@Transactional
public class PurchaseService {

	@Autowired
	private PurchaseRepository purchase_repo;

	public List<Purchase> listAll() {
		return purchase_repo.findAll();
	}

	public void save(Purchase purchase) {
		purchase_repo.save(purchase);
	}

	public Page<Purchase> getPurchaseByCustomer(Integer customerid) {

		return purchase_repo.FindPurchasePerCustomer(customerid, null);
	}

	public Page<Purchase> getPurchaseByProduct(Integer productid) {

		return purchase_repo.FindPurchasePerProduct(productid, null);
	}


}
