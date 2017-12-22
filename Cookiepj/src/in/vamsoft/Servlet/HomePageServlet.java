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
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		Object uname=session.getAttribute("username");
		PrintWriter out=response.getWriter();
		if(uname==null) {
			response.sendRedirect("Loginsession.html");
		}else {
			String username=uname.toString();
			out.println("<html><body><h1>Welcome"+username);
			out.println("<a href='TransferFunds'>Transfer Funds</a>");
			out.println("</h1></body></html>");
		}
	}

}
