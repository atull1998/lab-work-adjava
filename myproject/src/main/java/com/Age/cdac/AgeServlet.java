package com.Age.cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AgeServlet")
public class AgeServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		LocalDate dob = LocalDate.parse(request.getParameter("dob"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<h1>hii "+name+"<br>now your age is :"+calculateAgeyears(dob)+" Years "+calculateAgeMonth(dob)+" Months </h1>");
		out.write("</body></html>");
		
	}
		
	public static int calculateAgeyears(LocalDate dob)   
	{  
	
	LocalDate curDate = LocalDate.now();  
		if ((dob != null) && (curDate != null))   
		{  
			return Period.between(dob, curDate).getYears();  
		}  
		else  
		{  
			return 0;  
		}  
	}  
	public static int calculateAgeMonth(LocalDate dob)   
	{  
	
	LocalDate curDate = LocalDate.now();  
		if ((dob != null) && (curDate != null))   
		{  
			return Period.between(dob, curDate).getMonths();  
		}  
		else  
		{  
			return 0;  
		}  
	}
}  