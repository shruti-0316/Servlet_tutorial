package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("user_name");
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		String course = req.getParameter("course"); 
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shrut?useSSL=false", "root", "ganu1603");
				
			   String query = "insert into users(name,email,password,course) values(?,?,?,?)";
			   
			   PreparedStatement pstm = con.prepareStatement(query);
			   pstm.setString(1, name);
			   pstm.setString(2, email);
			   pstm.setString(3, password);
			   pstm.setString(4, course);
			   pstm.executeUpdate();
				pstm.close();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<h1>Name : "+name+"</h1>");
		out.print("<h1>Email : "+email+"</h1>");
		out.print("<h1>Password : "+password+"</h1>");
		out.print("<h1>Course : "+course+"</h1>");
		
		
	}

}
