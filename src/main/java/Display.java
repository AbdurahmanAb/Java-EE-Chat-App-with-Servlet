

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
public class Display extends HttpServlet {

	String uname = (String) session.getAttribute("name");
	String DB ="select image from Chatting Where username= ' "+uname+"' ";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatX", "root","abdu");


	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
	        Blob blob = rs.getBlob("image");
	        byte byteArray[] = blob.getBytes(1, (int) blob.length());
	        response.setContentType("image/gif");
	        OutputStream os = response.getOutputStream();
	        os.write(byteArray);
	        os.flush();
	        os.close();
	    } else {
	        System.out.println("No image found with this id.");
	    }
	} catch (Exception e) {
	    out.println(e);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
