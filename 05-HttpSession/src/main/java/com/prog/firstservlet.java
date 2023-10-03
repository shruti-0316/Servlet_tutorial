package com.prog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class firstservlet
 */
@WebServlet("/servlet1")
public class firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
String name = req.getParameter("name");
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<h1>Name:"+name+"</h1>");
		
		HttpSession session = req.getSession();
		session.setAttribute("username", name);
		
		out.print("<a href='servlet2?username="+name+"'>Servlet2</a>");
		
		
	}

}
