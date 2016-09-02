package com.niit.shoppingcartbackend;

import com.niit.shoppingcartbackend.dao.ProductDAO;

import com.niit.shoppingcartbackend.model.Product;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		Product product = (Product) context.getBean("product");
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");

		product.setProductId("P05");
		product.setProductName("AnarkaliDress");
		product.setDescription("This is the second product");
		product.setCategoryId("CT101");
		product.setSupplierId("S101");
		product.setQuantity(5);
		product.setPrice(5000);

		productDAO.saveOrUpdate(product);
	}
}
