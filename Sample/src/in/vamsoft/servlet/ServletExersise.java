package in.vamsoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletExersise
 */
public class ServletExersise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		        try{
		      String username = request.getParameter("username");
		      String dob = request.getParameter("dob");
		      String address =request.getParameter("address");
		      String gender =request.getParameter("gender");
		      String hobbies =request.getParameter("hobbies");
		      out.println(username);
		      out.println(dob);
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.77:1521:xe","hr","password");
		      PreparedStatement pst = con.prepareStatement("insert into  customer_reg_form values(?,?,?,?,?)");
		      pst.setString(1,username);
		      pst.setString(2,dob);
		      pst.setString(3, address);
		      pst.setString(4, gender);
		      pst.setString(5, hobbies);
		      int i = pst.executeUpdate();
		      if(i!=0){
		        out.println("<br>Record has been inserted");
		      }
		      else{
		        out.println("failed to insert the data");
		      }
		    }
		    catch (Exception e){
		      out.println(e);
		    }
	}
}



