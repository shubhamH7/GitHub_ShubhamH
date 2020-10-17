package com.form.moolya;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Registratiob extends HttpServlet {


	public PrintWriter out;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		response.setContentType("login.html");
		System.out.println("login....");
		 out = response.getWriter();
		
		String name = request.getParameter("name"); 
		String passd = request.getParameter("password");
		System.out.println(name);
		System.out.println(passd);
		
		Model m=new Model();
		m.setUsername(name);
		System.out.println(name);
		ArrayList al=m.dataDetails();
		if(al.isEmpty()==true)    
		{
	   
			response.sendRedirect("/MS10/fail.html");	
		}
		else 
		{
			session.setAttribute("al", m.al);
			session.setAttribute("al1", m.al1);
			session.setAttribute("al2", m.al2);
			response.sendRedirect("/MS10/show_data.jsp");
		}
	}
}
