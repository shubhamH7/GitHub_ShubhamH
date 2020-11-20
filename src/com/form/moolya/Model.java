package com.form.moolya;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Model extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String url="jdbc:oracle:thin:@localhost:1524:XE";
	String un="system";
	String pw="system";
	
	ArrayList al  = new ArrayList();
	ArrayList al1 = new ArrayList();
	ArrayList al2 = new ArrayList();
	
	public Connection con;
	public PreparedStatement pstmt;
	public String username;
	public String password;
	public String gender;
	public String email;
	public String phone_number;
	public String address;
	public String pin_code;
	private int i;

	private ResultSet res;

	
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPin_code() {
		return pin_code;
	}
	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}
	public Model()
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded");
			con = DriverManager.getConnection(url,un,pw);
			System.out.println("Connection is fine");
		} 
		catch (Exception e) 
		{
			System.out.println("Problem in connection");
		}
	}
	public ArrayList dataDetails() {
		
		try
		{
			System.out.println(username);
			PreparedStatement ps = con.prepareStatement("select * from REGISTRATION where NAME=?");
	    	ps.setString(1, username);
	    	res=ps.executeQuery();
	    	while (res.next()==true)
	    	{
	    		al.add(res.getString(1));
	    		al1.add(res.getString(4));
	    		al2.add(res.getString(5));	
	    	}
		} 
		catch (Exception e) {
			System.out.println("error in getData");
		}
		return al;
	}
	public void result()
	{
	try 
	{
		System.out.println("Inside inserting query...");
		pstmt = con.prepareStatement("insert into REGISTRATION values(?,?,?,?,?,?,?)");	
		System.out.println("prepare executed");
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		pstmt.setString(3, gender);
		pstmt.setString(4, email);
		pstmt.setString(5, phone_number);
		pstmt.setString(6, address);
		pstmt.setString(7, pin_code);
			
		i = pstmt.executeUpdate();
		System.out.println("Updating...!");
		
	}
	catch (Exception e1)
	{
		System.out.println("Problem in result");
	}
  }	
}
