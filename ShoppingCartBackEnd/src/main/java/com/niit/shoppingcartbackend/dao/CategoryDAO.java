package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.Category;

public interface CategoryDAO {
	public void saveOrUpdate(Category category);

	public void delete(String id);

	public Category get(String id);

	public List<Category> list();

}
