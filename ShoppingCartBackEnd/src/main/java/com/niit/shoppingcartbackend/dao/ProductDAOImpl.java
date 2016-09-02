package com.niit.shoppingcartbackend.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.shoppingcartbackend.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

	@Transactional
	public void delete(String id) {
		Product product = new Product();
		product.setProductId(id);
		sessionFactory.getCurrentSession().delete(product);
	}

	@Transactional
	public Product get(String id) {
		return sessionFactory.getCurrentSession().get(Product.class, id);
		// String hql = "from Product where productId=" + "'" + id + "'";
		// Query query = sessionFactory.getCurrentSession().createQuery(hql);
		// List<Product> listProducts = query.getResultList();
		// return listProducts.get(0);
	}

	@Transactional
	public List<Product> list() {
		List<Product> listProduct = sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;
	}
}