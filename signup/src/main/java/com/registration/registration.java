 package com.registration;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registration
 */
@WebServlet("/register")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("pass");
		String reupwd = request.getParameter("re_pass");
		String umobile = request.getParameter("contact");

		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		if(uname == null || uname.equals("")) {
			request.setAttribute("status", "Invalidename");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		
		if(uemail == null || uemail.equals("")) {
			request.setAttribute("status", "InvalideEmail");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		
		if(upwd == null || upwd.equals("")) {
			request.setAttribute("status", "InvalidePwd");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}else if(!upwd.equals(reupwd)) {
			request.setAttribute("status", "InvalideConfirmPassword");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		
		if(umobile == null || umobile.equals("")) {
			request.setAttribute("status", "InvalideMobile");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}else if(umobile.length() > 10 || umobile.length() < 10) {
			request.setAttribute("status", "InvalideMobileLength");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");

			   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=false", "root", "ganu1603");
			   String query = "insert into users(uname,uemail,upwd,umobile) values(?,?,?,?)";

    		  PreparedStatement pstm =  con.prepareStatement(query);
    		pstm.setString(1, uname);
			pstm.setString(2, uemail);
			pstm.setString(3, upwd);
			pstm.setString(4, umobile);
			int rowCount = pstm.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if(rowCount > 0) {
				request.setAttribute("status","success");
			}else {
				request.setAttribute("status","failed");
			}
			dispatcher.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
