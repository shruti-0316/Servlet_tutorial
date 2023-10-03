package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class secondProgram extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Generic servlet");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("welcome to generic servlet world \n");
		out.print("Today is my new day" + new Date().toString());
		
	}

}
