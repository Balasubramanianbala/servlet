package in.vamsoft.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validateuser
 */
@WebServlet("/Validateuser")

public class Validateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
 	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		PrintWriter out=response.getWriter();
		if(uname.equals("Balu")&& pwd.equals("Balu")) {
			response.sendRedirect("Success.html");
		}else {
			out.println("<h1>Validation here</h1>");
			RequestDispatcher reqd=request.getRequestDispatcher("ErrorServlet");
			reqd.forward(request, response);
		}
	}

}
