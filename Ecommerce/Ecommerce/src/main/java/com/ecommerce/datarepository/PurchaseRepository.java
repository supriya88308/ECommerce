
package com.ecommerce.datarepository;

import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

	@Query(value = "SELECT Purchase.idpurchase, Purchase.idproduct, Purchase.idcustomer, Purchase.purchased_date, "
			+ "products.unit_price,products.product_name " + "FROM Purchase "
			+ "LEFT JOIN products ON Purchase.idproduct = products.idproduct "
			+ " WHERE Purchase.idcustomer = ?1", nativeQuery = true)
	public Page<Purchase> FindPurchasePerCustomer(Integer CustomerId, org.springframework.data.domain.Pageable page);

	@Query(value = "SELECT Purchase.idpurchase, Purchase.idproduct, Purchase.idcustomer, Purchase.purchased_date, "
			+ "customers.customer_name,customers.address " + "FROM Purchase "
			+ "LEFT JOIN customers ON Purchase.idcustomer = customers.idcustomer "
			+ " WHERE Purchase.idproduct = ?1", nativeQuery = true)
	public Page<Purchase> FindPurchasePerProduct(Integer ProductId, org.springframework.data.domain.Pageable page);
}
