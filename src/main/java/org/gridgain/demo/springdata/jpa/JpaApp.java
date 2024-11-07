package org.gridgain.demo.springdata.jpa;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaApp {

	private EntityManager em;

	public static void main(String[] args) {
		new JpaApp();
	}

	public JpaApp() {
	    Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING);

	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-co");
		em = emf.createEntityManager();
		
		Orders order = em.find(Orders.class, 1);
		System.out.println(order);
		
		Shipments shipments = em.find(Shipments.class, 100);
		System.out.println(shipments);
		
		em.close();
	}

}
