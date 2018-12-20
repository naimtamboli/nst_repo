package com.uxpsystems.assignment.userassignment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.uxpsystems.assignment.userassignment.model.User;

@Repository
public class UserDao {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public User getUserDetails(Long id) {
		User user = entityManager.find(User.class,id);
		return user;
	}
	
	public List getAllUserDetails() {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(User.class);
		return criteria.list();
	}
	
	    public void createUser(User user) {
	       // entityManager.persist(user);
	        entityManager.merge(user);
	    }

	    public void updateUser(User user) {
	        entityManager.merge(user);
	    }

	    public void deleteUser(Long id) {
	    	User user = getUserDetails(id);
	        if (user != null) {
	            entityManager.remove(user);
	        }
	    }
	
	
/*	@Autowired
    private SessionFactory sessionFactory;
	
 
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public User getUserDetails(Long id) {
    	 Criteria criteria = getSession().createCriteria(User.class);
         criteria.add(Restrictions.eq("id",id));
         return (User) criteria.uniqueResult();
	}
	
	public List<User> getAllUserDetails() {
		Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
	}
	
	    public void createUser(User user) {
	    	getSession().update(user);
	    }

	    public void updateUser(User user) {
	    	getSession().update(user);
	    }

	    public void deleteUser(Long id) {
	    	User user = getUserDetails(id);
	        if (user != null) {
	        	getSession().delete(user);
	        }
	    }*/
	
	

}
