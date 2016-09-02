package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.model.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		Supplier supplier = (Supplier) context.getBean("supplier");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		supplier.setId("S105");
		supplier.setName("Prem");
		supplier.setContactNo("9025863627");
		supplier.setAddress("Pune");
		supplier.setEmail("abc@.gcom");
		supplierDAO.saveOrUpdate(supplier);

	}
}
