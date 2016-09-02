package com.niit.shoppingcartbackend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.shoppingcartbackend.model.UserDetails;

@Repository("userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(UserDetails userDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
	}

	@Transactional
	public void delete(String user_name) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUser_name(user_name);
		sessionFactory.getCurrentSession().delete(userDetails);
	}

	@Transactional
	public UserDetails get(String User_name) {
		sessionFactory.getCurrentSession().get(UserDetails.class, User_name);
		return null;
	}

	@Transactional
	public List<UserDetails> list() {
		List<UserDetails> listuserDetails = sessionFactory.getCurrentSession().createCriteria(UserDetails.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listuserDetails;
	}
}
