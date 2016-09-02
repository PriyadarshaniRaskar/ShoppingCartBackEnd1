package com.niit.shoppingcartbackend.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.shoppingcartbackend.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}

	@Transactional
	public void delete(String id) {
		Cart cart = new Cart();
		cart.setCartProductId(id);
		sessionFactory.getCurrentSession().delete(cart);
	}

	@Transactional
	public Cart get(String id) {
		return sessionFactory.getCurrentSession().get(Cart.class, id);
		/*String hql="from Cart where CartProductId=" + "'" + id + "'";
		 Query query=(Query)sessionFactory.getCurrentSession().createQuery(hql);
		 List<Cart> listCart =(List<Cart>) query.getResultList();
		 if(listCart!=null && !listCart.isEmpty())
		 {
		return listCart.get(0);
		 }*/
	}

	@Transactional
	public List<Cart> list() {
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>)
		sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCart;
	}
}
