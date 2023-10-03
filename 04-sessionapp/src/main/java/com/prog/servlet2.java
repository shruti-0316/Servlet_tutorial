package com.prog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet2
 */
@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
//		String name = req.getParameter("name");
		PrintWriter out = resp.getWriter();
		
		Cookie[] ck = req.getCookies();
		
		
		
		resp.setContentType("text/html");
		out.print("welcome to servlet2, name= "+ ck[0].getValue());

		
	}

}
