package com.niit.shoppingcartbackend.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.shoppingcartbackend.model.UserLogin;

@Repository(value = "userLoginDAO")
public class UserLoginDAOImpl implements UserLoginDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public UserLoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(UserLogin userLogin) {
		sessionFactory.getCurrentSession().saveOrUpdate(userLogin);
		// Can also do in this way also
		// Session session = sessionFactory.getCurrentSession();
		// session.saveOrUpdate(userLogin);
	}

	@Transactional
	public void delete(String id) {
		UserLogin userLogin = new UserLogin();
		userLogin.setUserId(id);
		sessionFactory.getCurrentSession().delete(userLogin);
	}

	@Transactional
	public UserLogin get(String id) {
		// sessionFactory.getCurrentSession().get(UserLogin.class,id);
		String hql = "from UserLogin where userId=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserLogin> listuserLogin = query.getResultList();
		if (listuserLogin != null && !listuserLogin.isEmpty()) {
			return listuserLogin.get(0);
		}
		return null;
	}

	@Transactional
	public List<UserLogin> list() {
		@SuppressWarnings("unchecked")
		List<UserLogin> listuserLogin = (List<UserLogin>) sessionFactory.getCurrentSession()
				.createCriteria(UserLogin.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listuserLogin;
	}
}
