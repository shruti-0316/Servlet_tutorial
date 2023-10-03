package com.registration;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("username");
		String upwd = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher =  null;
		
		if(uemail == null || uemail.equals("")) {
			request.setAttribute("status", "InvalideEmail");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
		if(upwd == null || upwd.equals("")) {
			request.setAttribute("status", "InvalidePwd");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		try {
			Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=false", "root", "ganu1603");
			   String query = "SELECT * FROM company.users where uname=? and upwd=?";

	    	   PreparedStatement pstm =  con.prepareStatement("select * from users WHERE uemail= ? and upwd= ?");
			   pstm.setString(1, uemail);
				pstm.setString(2, upwd);
				ResultSet rs = pstm.executeQuery();
				if(rs.next()) {
					session.setAttribute("name", rs.getString("uname"));
					dispatcher = request.getRequestDispatcher("index.jsp");
				} else {
					request.setAttribute("status","failed");
					dispatcher = request.getRequestDispatcher("login.jsp");	
				}
				dispatcher.forward(request, response);

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
