package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoppingcartbackend.dao.UserLoginDAO;
import com.niit.shoppingcartbackend.model.UserLogin;

public class UserLoginTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		UserLoginDAO userLoginDAO = (UserLoginDAO) context.getBean("userLoginDAO");
		UserLogin userLogin = (UserLogin) context.getBean("userLogin");
		
		userLogin.setUserId("UL13");
		userLogin.setUserName("Raj");
		userLogin.setPassword("raj101");
		userLoginDAO.saveOrUpdate(userLogin);
	}
}
