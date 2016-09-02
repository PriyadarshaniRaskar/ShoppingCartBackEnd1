package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoppingcartbackend.dao.UserDetailsDAO;
import com.niit.shoppingcartbackend.model.UserDetails;

public class UserDetailsTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		UserDetails userDetails = (UserDetails) context.getBean("userDetails");
		UserDetailsDAO userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		userDetails.setUser_id("U104");
		userDetails.setUser_name("Mohini");
		userDetails.setPhone_no("9502652032");
		userDetails.setGender("Female");
		userDetails.setPassword("25035");
		userDetailsDAO.saveOrUpdate(userDetails);
	}
}
