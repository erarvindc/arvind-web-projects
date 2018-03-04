package com.arvind.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CustomerDAO {

	//Testing 
	public static void main( String[] args) {
	
		createCustomer ("er.arvindc", "ArvindC", 1231212 );
		
		
	}
	
	
	public static void createCustomer( String email, String name, int phone ) {
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Customer.class);
		
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		
		SessionFactory sf = config.buildSessionFactory( serviceRegistry );

		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save( new Customer ( email, name, phone ) );
		
		tx.commit();
		
	}
	
	
	
}
