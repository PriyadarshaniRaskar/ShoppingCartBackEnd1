package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.Supplier;

public interface SupplierDAO {
	public void saveOrUpdate(Supplier supplier);

	public void delete(String id);

	public Supplier get(String id);

	public List<Supplier> list();

}
