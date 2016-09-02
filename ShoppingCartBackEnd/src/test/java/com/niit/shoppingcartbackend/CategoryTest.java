package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext
;
import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.model.Category;

public class CategoryTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		Category category = (Category) context.getBean("category");
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

		category.setId("CT105");
		category.setName("ABCD");
		category.setDescription("WESTERN");
		categoryDAO.saveOrUpdate(category);
	}
}