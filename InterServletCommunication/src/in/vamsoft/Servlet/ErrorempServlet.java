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
 * Servlet implementation class ErrorempServlet
 */
@WebServlet("/ErrorempServlet")
public class ErrorempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ename=request.getParameter("ename");
		PrintWriter out = response.getWriter();
		out.println(ename+"<h2>no null value should be submitted</h2>");
		RequestDispatcher req = request.getRequestDispatcher("Employee.html");
		req.include(request, response);
	}

}
