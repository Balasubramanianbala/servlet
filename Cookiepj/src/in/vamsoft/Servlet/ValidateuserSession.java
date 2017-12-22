package in.vamsoft.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateuserSession
 */
@WebServlet("/ValidateuserSession")
public class ValidateuserSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		if(uname.equals("Balu")&& pwd.equals("Balu")) {
			session.setAttribute("username", uname);
			RequestDispatcher dispatcher=request.getRequestDispatcher("HomePageServlet");
			dispatcher.forward(request, response);
		}else {
			out.println("<h1>Validation here</h1>");
			RequestDispatcher reqd=request.getRequestDispatcher("ErrorServlet");
			reqd.forward(request, response);
		}
	}

	

}
