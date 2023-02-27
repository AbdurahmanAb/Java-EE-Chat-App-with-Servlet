package com.socket.auth;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
@WebServlet("/register")
public class Register extends HttpServlet {
	
	
	  public static final String UPLOAD_DIR = "./image";
	    public String dbFileName = "";

@SuppressWarnings("deprecation")
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
	res.setContentType("text/html; charset=UTF-8");
	
	PrintWriter out = res.getWriter();
	String uname = req.getParameter("uname");
	String pwd = req.getParameter("pwd");
	String cpwd = req.getParameter("cpwd");
	String email = req.getParameter("email");
	String Phone = req.getParameter("contact");
	
	
	
	Part part =  req.getPart("avatar");

    //
    String fileName = extractFileName(part);//file name
  
String savePath = "/home/abdu/eclipse-workspace/ChatX/src/main/webapp/image" + File.separator + fileName;
    System.out.println("savePath: " + savePath);
    File fileSaveDir1 = new File(savePath);
    part.write(savePath + File.separator);
    System.out.println("FileName: " + fileName);
    
    /*if you may have more than one files with same name then you can calculate some random characters
     and append that characters in fileName so that it will  make your each image name identical.*/
   	

	
	HttpSession ss = req.getSession();
	RequestDispatcher Dispatcher = null;
	
	if(pwd.equals(cpwd)) {
	//Hash The Password
	String PassToHash = pwd;
	String Hashed = null;
	try {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(PassToHash.getBytes());
		
		byte[] bytes= md.digest();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			Hashed = sb.toString();
		}
		
		
		
		
		
		
	}catch(NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
	
	
	//Register The User To THe data base
	
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatX", "root","abdu");
	String sql = "insert into Chatting values (?,?,?,?,?,?)";
	PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, uname);
		pst.setString(2, Hashed);
		pst.setString(3, email);
		pst.setString(4, Phone);
		pst.setString(5, savePath);
		pst.setString(6, fileName);
		int rs = pst.executeUpdate();
		pst.close();
		if(rs>0) {
			
			Dispatcher = req.getRequestDispatcher("login.jsp");
			Dispatcher.forward(req, res);
		}else {
			Dispatcher = req.getRequestDispatcher("Error.jsp");
			Dispatcher.forward(req, res);
		}

	 
	
	}catch(Exception e){
		e.printStackTrace();
	}
	
	}else {
		out.print("Password Missmatch");
		Dispatcher = req.getRequestDispatcher("Error.jsp");
		Dispatcher.forward(req, res);
	}
	}

private String extractFileName(Part part) {
	// TODO Auto-generated method stub
	 String contentDisp = part.getHeader("content-disposition");
     String[] items = contentDisp.split(";");
     for (String s : items) {
         if (s.trim().startsWith("filename")) {
             return s.substring(s.indexOf("=") + 2, s.length() - 1);
         }
     }
	return "";
}

}
