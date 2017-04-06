package com.harish.dao;

import org.apache.tomcat.jni.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.harish.model.UserDetails;



@SuppressWarnings("deprecation")
@Transactional
@Repository("userdao")
public class UserDaoImpl implements UserDao
{
	
SessionFactory sessionFactory;

	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}



	public boolean addUsers(UserDetails user) {
		try {
			System.out.println("entered in add user dao");

			sessionFactory.getCurrentSession().persist(user);

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public UserDetails getUser(int id) {

		return sessionFactory.getCurrentSession().get(UserDetails.class, Integer.valueOf(id));
	}

	public boolean updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		System.out.println("user details in userdaoimp:::::::::" + user);
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserDetails getUserNameByUserName(String name) {
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery("FROM UserDetails WHERE email=:email");
		query.setParameter("email", name);
		UserDetails UserDetails = (UserDetails) query.getSingleResult();
		return UserDetails;
	}

	public UserDetails getUserByEmail(String email) {
		@SuppressWarnings("rawtypes")
		Query q = sessionFactory.getCurrentSession().createQuery("From UserDetails where email=:email", UserDetails.class);
		q.setParameter("email", email);
		try {
			Object o = q.getSingleResult();
			return (UserDetails) o;

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}



	

	
}
