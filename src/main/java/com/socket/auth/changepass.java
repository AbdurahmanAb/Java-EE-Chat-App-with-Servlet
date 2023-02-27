package com.socket.auth;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 //MD5
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class changepass
 */

@WebServlet("/change")
public class changepass extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
	String psd = request.getParameter("psd");
	String cpsd = request.getParameter("cpsd");
	String email = (String) session.getAttribute("email");
	String Hashed=null;
	RequestDispatcher Dispatcher =null;
	if(psd.equals(cpsd)) {
	try {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(psd.getBytes());
        byte[] bytes= md.digest();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			Hashed = sb.toString();
		}
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	

       try {
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatX","root","abdu");
    			//String sql =  "select * from Chatting where email='" + name + "' AND password='" + Hashed + "'";
    		String mysql = "UPDATE Chatting  SET password = '"+ Hashed +"'  where  email = '" + email + "' ";
    		Statement pst = con.createStatement();
    	    int i = pst.executeUpdate(mysql);
            con.close();    	   
    	   
    	   Dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("status", "updated");
			Dispatcher.forward(request, response);
			
       }catch(Exception E) {
    	   E.printStackTrace();
       }
		
		
		
		
	}	
	else {
		Dispatcher = request.getRequestDispatcher("changepass.jsp");
		request.setAttribute("status", "Mismatch");
		Dispatcher.forward(request, response);
	}
	
	
}
	}

