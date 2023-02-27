package com.socket;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class reloaddata
 */

@WebServlet("/reload")
public class reloaddata extends HttpServlet {
 public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	HttpSession ss = req.getSession();
	 PrintWriter out = res.getWriter();


	 try {
		 HttpSession session = req.getSession();
		res.setContentType("text/html");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatX", "root","abdu");
	    Statement stmt = con.createStatement();
	    String messages = "select * from chatting_detail";

	  ResultSet rs = stmt.executeQuery(messages);
	  while(rs.next()) {
		String uname = rs.getString(1);
		  String msg = rs.getString(2);
		  String date = rs.getString(3);
		  String time = rs.getString(4);
		  String ClassName ;
		  String txtClass;
		  if(session.getAttribute("name").equals(uname)) {
			  ClassName = "message_container";
			  txtClass = "message__txt";
		  }else {
			  ClassName = "message_container self";
			  txtClass = "message__txt self__txt";
		  }
		  String path = (String) ss.getAttribute("file");
		//out.print("<input id=\"namer\" value=\" "+ uname  +"\" type=\"hidden\" />");
		 out.print(" <div class=\""+ClassName+" \">\n"
				 
				 
		 		+ "            <img src=\"asset/User5.jpg\" alt=\"\" class=\"message__img\">\n"
+"    <p class=\"name\">"+uname+"</p>"
		 		+ "          <div class=\""+txtClass+"\">\n"
		 		+ "            <p >"+msg+"</p>\n"
		 		+ "            <p class=\"date_time\">\n"
		 		+ "                <span class=\"date__span\"> "+date+"</span>\n"
		 		+ "                <span  class=\"date__span\">"+time+"</span>\n"
		 		+ "            </p>\n"
		 		+ "           </div>"
		 		+ "        </div>");
		/*
		 * 
		 */

	  }
	  con.close();
	 }catch(Exception E) {
		 E.printStackTrace();
	 }
 }
	
}



