package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.Cart;

public interface CartDAO {
	public void saveOrUpdate(Cart cart);

	public void delete(String id);

	public Cart get(String id);

	public List<Cart> list();

}
