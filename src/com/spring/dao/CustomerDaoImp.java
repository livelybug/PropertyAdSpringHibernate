package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.Customer;
import com.spring.domain.PrpUser;



@Repository
public class CustomerDaoImp implements PrptUserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addUser(PrpUser user) {
		//Session session = HibernateUtils.openSession();
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		session.save((Customer)user);
		//session.getTransaction().commit();
		//HibernateUtils.closeSession(session);

	}

	@Transactional
	public PrpUser getUserById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		return customer;
	}

	@Transactional
	public List<PrpUser> getUserList() {
		Session session = sessionFactory.getCurrentSession();
		List<PrpUser> cstLst = session.createQuery("from Customer").list(); 
		return cstLst;
	}

	@Transactional
	public void deleteUserById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Customer cst = (Customer) session.get(Customer.class, id);
		
		if(cst != null)
			session.delete(cst);
	}

	@Override
	@Transactional
	public List<PrpUser> duplcExist(PrpUser user) {
		
		Session session = sessionFactory.getCurrentSession();
		List<PrpUser> users = new ArrayList<PrpUser>();
		
		String hql1 = "from Customer where userName = :userName or email = :email";
		
		Query query = session.createQuery(hql1);
		query.setParameter("userName", ((Customer)user).getUsername());
		query.setParameter("email", ((Customer)user).getEmail());
		users = query.list();
		
		if(users.size() > 0)
			return users;
		else
			return null;
	}

	@Override
	@Transactional
	public PrpUser findUserByName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		return (Customer) session.createCriteria( Customer.class ).
				add( Restrictions.eq("username", userName) ).uniqueResult();
	}

}
