package in.vamsoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.dao.UserCreationDao;
import in.vamsoft.pojo.UserCreation;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 HttpSession session =request.getSession();
	      PrintWriter out = response.getWriter();	      	     
	      String name =  request.getParameter("name");
	      int  phno =Integer.parseInt( request.getParameter("phno"));
	      String emailid =  request.getParameter("email");
	      System.out.println(name);
	      String password =  request.getParameter("psw");
	      System.out.println(password);	 
	      UserCreation model = new UserCreation(name,phno,emailid,password);
	       new UserCreationDao().UserRegister(model);	      
	       out.print("sucess");
	       response.sendRedirect("Login.html");
	}

}
