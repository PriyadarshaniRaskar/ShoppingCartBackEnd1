package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.CartDAO;
import com.niit.shoppingcartbackend.model.Cart;

public class CartTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		
		Cart cart = (Cart) context.getBean("cart");
		CartDAO cartDAO = (CartDAO) context.getBean("cartDAO");
		cart.setCartProductId("CP3");
		cart.setCartProductName("Kurti");
		cart.setCartProductUser("Siya");
		cart.setCartProductPrice(50000);
		cartDAO.saveOrUpdate(cart);
	}
}