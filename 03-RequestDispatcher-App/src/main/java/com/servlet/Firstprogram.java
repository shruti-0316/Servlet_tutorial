package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Firstprogram extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		PrintWriter out = res.getWriter();
		RequestDispatcher rd;
		
		if("demo@gmail.com".equals(email) && "demo".equals(password)) 
		{
		//home page redirect	
			rd = req.getRequestDispatcher("/servlet2");
			rd.forward(req, res);
		}
		else {
			//redirect login page
			res.setContentType("text/html");
			out.print("<h4>invalid email or password</h4>");	
			rd = req.getRequestDispatcher("/index.html");
			rd.include(req, res);
		}
		
	}

}
