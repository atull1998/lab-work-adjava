package com.cdac.app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.dao.EmployeeDao;
import com.cdac.entity.Employee;

public class InsertEmployee{
				
	    public static void main (String args[]){
		/*Employee emp = new Employee();
		emp.setEmpno(request.getParameter("empno"));
		emp.setName(request.getParameter("name"));
		emp.setSalary(request.getParameter("salary"));
		emp.setDateOfJoining(request.getParameter("doj"));
		
		EmployeeDao dao = new EmployeeDao();
		dao.add(emp);
		
		out.write("<h1> Record inserted successfully...!!</h1>");
		*/
	    	EmployeeDao dao = new EmployeeDao();
	    	Employee emp = dao.fetch(1002);
	    	System.out.println(emp.getName()+" "+emp.getSalary());
	 
	    }
	    
}
