package com.example;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class FirstStatelessEjb
 */
@Stateless
@LocalBean
public class FirstStatelessEjb implements FirstStatelessEjbRemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public FirstStatelessEjb() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void insert(String name, String password) {
    	entityManager.persist(new User(password,name));
    }

}
