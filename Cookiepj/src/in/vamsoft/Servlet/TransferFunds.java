package in.vamsoft.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class TransferFunds
 */
@WebServlet("/TransferFunds")
public class TransferFunds extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession=request.getSession();
		Object uname=httpSession.getAttribute("username");
		PrintWriter out=response.getWriter();
		if(uname==null) {
			response.sendRedirect("Loginsession.html");
		}else {
			String name=uname.toString();
			out.println("<html><body><h1>Transfer funds success fully"+name);
			out.println("<a href='Logout'>Logout</a>");
			
			out.println("</h1></body></html>");
			
		}
	}

}
