package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

}
