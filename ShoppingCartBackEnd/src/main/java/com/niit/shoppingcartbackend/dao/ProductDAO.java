package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.Product;

public interface ProductDAO {
	public void saveOrUpdate(Product Product);

	public void delete(String id);

	public Product get(String id);

	public List<Product> list();

}
