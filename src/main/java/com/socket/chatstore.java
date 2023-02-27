package com.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class chatstore
 */


@WebServlet("/chatstore")
public class chatstore extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		try {
			res.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatX","root","abdu");
		
			String uname = req.getParameter("uname");
			String msg = req.getParameter("msg");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss a");
			Date date = new Date();
			String Senddate = sdf.format(date);
			String SendTime = sdf2.format(date);
			
			
			String query = "insert into chatting_detail values('"+uname+"','"+msg+"','"+Senddate+"','"+SendTime+"')";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			int rs = pst.executeUpdate(query);
			
			con.close();
;		}catch(Exception E) {
			E.printStackTrace();
		}
	}
	

}
