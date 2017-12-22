package in.vamsoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calculation
 */
@WebServlet("/calculation")
public class calculation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String n1 = request.getParameter("fnum");
		int num1 = Integer.parseInt(n1); 
		String n2 = request.getParameter("snum");
		int num2 = Integer.parseInt(n2); int ans=0;
		if(request.getParameter("calc").equals("Add"))
			ans = num1+num2;
		if(request.getParameter("calc").equals("Sub"))
			ans = num1-num2;
		if(request.getParameter("calc").equals("Div"))
			ans = num1/num2;
		if(request.getParameter("calc").equals("Multi"))
			ans = num1*num2;
		response.getWriter().println(ans); 
	}

}
