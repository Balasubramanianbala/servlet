package in.vamsoft.filterde;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	String uname="admin";
	String passwd="admin";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		HttpSession session;
		if(user.equals(uname)&& pwd.equals(passwd) ){
		
			session= request.getSession();
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(20*60);
			Cookie cname=new Cookie("userc", user);
			response.addCookie(cname);
			response.sendRedirect("Loginss.jsp");
			
		}else {
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/Login.html");
			response.getWriter().println("your input is wrong");
			rd.include(request, response);
		}
		
	}

}
