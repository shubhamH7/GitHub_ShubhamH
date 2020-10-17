package com.form.moolya;

import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Registration extends HttpServlet
	{
	private static final long serialVersionUID = 1L;
	public int j;
	public int i;
	public PrintWriter out;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			response.setContentType("Form_Fill.html");
			out=response.getWriter();
			
			String un1 = request.getParameter("username");
			String p1  = request.getParameter("password");
			String g   = request.getParameter("gender");
			String e   = request.getParameter("email");
			String ph  = request.getParameter("phone_number");
			String ad  = request.getParameter("address");
			String pc  = request.getParameter("pin_code");
			System.out.println(un1);
			
			Model m=new Model();
			m.setUsername(un1);
			m.setPassword(p1);
			m.setGender(g);
			m.setEmail(e);
			m.setPhone_number(ph);
			m.setAddress(ad);
			m.setPin_code(pc);
			m.result();
			m.getI();
			m.setI(j);
		
			
			if(i>0)
			{
				response.sendRedirect("unsuccessful.html");
			}
			else
			{
				response.sendRedirect("successful.html");
			}
			
		}
	}
 
	

 