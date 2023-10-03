package com.prog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class servletses extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name1");
		PrintWriter out = resp.getWriter();
		
		Cookie ck = new Cookie("name1", name);
		resp.addCookie(ck);
		
		resp.setContentType("text/html");
		out.print("welcome to servlet1, name= "+ name);
		
		
		
		
		out.print("<br><a href='servlet2'>servlet2</a>");
		
	}

}
