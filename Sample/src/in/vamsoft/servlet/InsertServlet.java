package in.vamsoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.Dao.UserDao;
import in.vamsoft.pojo.User;

/**
 * Servlet implementation class InsertServlet
 */
//@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String name=request.getParameter("fname");
		String email=request.getParameter("email");
		String pwd=request.getParameter("passwd");
		User u=new User(name, email, pwd);
		UserDao uu=new UserDao();
		boolean e=uu.addUser(u);
		if(e) {
			response.getWriter().println("inserted successfully");
		}
		session.setAttribute("User",u);	
	}

}
