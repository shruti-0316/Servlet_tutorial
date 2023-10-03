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
 * Servlet implementation class secondservlet
 */
@WebServlet("/servlet2")
public class secondservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("username");
		
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>Name:"+name+"</h1>");
		
	}

	

}
