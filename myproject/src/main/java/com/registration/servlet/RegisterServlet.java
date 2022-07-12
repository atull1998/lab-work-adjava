package com.registration.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter ("name");
		String email = request.getParameter ("email");
		int mobileNo = Integer.parseInt(request.getParameter("mobileNo"));
		String username = request.getParameter ("username");
		String password = request.getParameter ("password");
		
		//jdbc code to insert in database 
		//to create table : create table customer(id int primary key auto_increment, name varchar(20), email varchar(30), mobileno int , username varchar(15),password varchar(15));
		try {
			//drivers loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//creating connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","cdac");
			
			boolean isCustomerPresent= false;
			//preparing the query to know if the email is present or not in the database  
			// if email is present it will return 1 if mail not present then it will return 0.
			PreparedStatement pst =conn.prepareStatement("select count(*) from customer where email = ?");
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				int c =rs.getInt(1);
				if (c == 1)
					isCustomerPresent = true;
				
			}
			
			if (!isCustomerPresent) {
			
			//query to insert values in the database.
			PreparedStatement st = conn.prepareStatement("insert into customer(name,email,mobileNo,username,password) values(?,?,?,?,?)");
	        st.setString(1, name);
	        st.setString(2,email);
	        st.setInt(3,mobileNo);
	        st.setString(4,username);
	        st.setString(5, password);
	        st.executeUpdate();
	        
			}
	        conn.close();
	        
	}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<h1>Registration Successful..!</h1>");
		out.write("</body></html>");
	
	}
}

