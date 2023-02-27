package com.socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.*;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**



 * 
 * 
 * Servlet implementation class login
 */


@WebServlet("/login")
public class Login extends HttpServlet {
	
public void doPost(HttpServletRequest request, HttpServletResponse res) throws IOException, ServletException {
	String name = request.getParameter("uname");
	String pwd = request.getParameter("pwd");
	PrintWriter out = res.getWriter();
	HttpSession ss = request.getSession();
	RequestDispatcher Dispatcher = null;
	if(name==null || name.equals("") && pwd==null || pwd.equals("") ) {
		request.setAttribute("status", "No input");
		Dispatcher = request.getRequestDispatcher("login.jsp");
		Dispatcher.forward(request, res);
	}
	if(name==null || name.equals("")) {
		request.setAttribute("status", "invalid name");
		Dispatcher = request.getRequestDispatcher("login.jsp");
		Dispatcher.forward(request, res);
	}
	if(pwd==null || pwd.equals("")) {
		request.setAttribute("status", "invalid pwd");
		Dispatcher = request.getRequestDispatcher("login.jsp");
		Dispatcher.forward(request, res);
	}
	
	String Hashed = null;
	try {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(pwd.getBytes());
		
		byte[] bytes = md.digest();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			Hashed = sb.toString();
		}
		
		
	} catch (NoSuchAlgorithmException e1) {
		
		e1.printStackTrace();
	}
	
	
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatX","root","abdu");
		String sql =  "select * from Chatting where username='" + name + "' AND password='" + Hashed + "'";
		Statement pst = con.createStatement();
		
		ResultSet rs = pst.executeQuery(sql);
		if(rs.next()) {
		String filePath = rs.getString("filePath");
		ss.setAttribute("name", name);
		ss.setAttribute("file", filePath);
		Dispatcher = request.getRequestDispatcher("landing.jsp");
		Dispatcher.forward(request, res);
			
		}
		else {
			request.setAttribute("value", "incorrect");
			Dispatcher = request.getRequestDispatcher("login.jsp");
			Dispatcher.forward(request, res);
	

		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

}
 


