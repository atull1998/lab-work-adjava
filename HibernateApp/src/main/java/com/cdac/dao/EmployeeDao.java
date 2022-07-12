package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Employee;

//dao = data access object 
//classes which contains database related code 
// are commonly referred to as Dao class

public class EmployeeDao {
	
	public void add(Employee emp) {
	//during this step persistence.xml file will be read
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Learning-hibernate");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			em.persist(emp); //persist will generate insert query
			
			tx.commit();
			
			emf.close();
}
	public Employee fetch(int empno) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		//find method generates select query where primary key = ?
		
		Employee emp = em.find(Employee.class, empno);	
		
		emf.close();
		return emp;
	}
}
