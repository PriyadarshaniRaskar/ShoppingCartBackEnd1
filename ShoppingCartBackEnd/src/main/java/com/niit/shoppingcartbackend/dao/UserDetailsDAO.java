package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.UserDetails;

public interface UserDetailsDAO {
	public void saveOrUpdate(UserDetails userDetails);

	public void delete(String user_name);

	public UserDetails get(String user_name );

	public List<UserDetails> list();

}

