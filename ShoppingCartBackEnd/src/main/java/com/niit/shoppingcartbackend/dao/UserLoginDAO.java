package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.UserLogin;

public interface UserLoginDAO {
	public void saveOrUpdate(UserLogin userLogin);

	public void delete(String id);

	public UserLogin get(String id);

	public List<UserLogin> list();

}
