package in.vamsoft.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import in.vamsoft.dao.UserCreationDao;
import in.vamsoft.pojo.UserCreation;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserCreation user = new UserCreation();
	UserCreationDao dao = new UserCreationDao();
	HttpSession session;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String uname = request.getParameter("uname");
			String password = request.getParameter("pwd");
			user.setEmail_id(uname);
			user.setPasswd(password);

			if(uname.equals("admin")&& password.equals("admin"))  {
				response.sendRedirect("Home.jsp");
			}else if(dao.userValidate(uname, password))
	        {
				session = request.getSession();
				String name=dao.getName(uname);
				System.out.println(name);
				session.setAttribute("name", name);
	            RequestDispatcher rs = request.getRequestDispatcher("Questionservlet");
	            rs.forward(request, response);
	        }

			else {
				response.sendRedirect("Login.html"); // error page
		}
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	
	}
}
