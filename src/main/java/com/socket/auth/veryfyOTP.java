package com.socket.auth;

import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class veryfyOTP
 */

@WebServlet("/verify")
public class veryfyOTP extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =  request.getSession();
   int value =Integer.parseInt(request.getParameter("otp"));
String email = (String) session.getAttribute("email");
RequestDispatcher Dispatcher = null;
		int otp = (int) session.getAttribute("otp");
		if(otp == value) {
			Dispatcher = request.getRequestDispatcher("changepass.jsp");
			request.setAttribute("email", email);
			request.setAttribute("status", "right");
			Dispatcher.forward(request, response);
		}
		else {
			Dispatcher = request.getRequestDispatcher("verifyOTP.jsp");
			request.setAttribute("status", "wrong");
			Dispatcher.forward(request, response);
   
		}
	}

}
