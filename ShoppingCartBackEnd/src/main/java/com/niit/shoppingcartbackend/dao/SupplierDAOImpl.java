package com.niit.shoppingcartbackend.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.shoppingcartbackend.model.Supplier;

@Repository(value = "supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}

	@Transactional
	public void delete(String id) {
		Supplier supplier = new Supplier();
		supplier.setId(id);
		sessionFactory.getCurrentSession().delete(supplier);
	}

	@Transactional
	public Supplier get(String id) {
		return sessionFactory.getCurrentSession().get(Supplier.class, id);
		// String hql = "from supplier where supplierId=" + "'" + id + "'";
		// Query query=sessionFactory.getCurrentSession().createQuery(hql);
		// List<Supplier> listSuppliers = query.getResultList();
		// if(listSuppliers!=null && !listSuppliers.isEmpty() )
		// return listSuppliers.get(0);
		// else
		// return null;
	}

	@Transactional
	public List<Supplier> list() {
		@SuppressWarnings("unchecked")
		List<Supplier> listsupplier = sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listsupplier;
	}

}
