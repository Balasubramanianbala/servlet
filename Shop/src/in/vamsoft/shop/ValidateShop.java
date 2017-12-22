package in.vamsoft.shop;

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
 * Servlet implementation class ValidateShop
 */
@WebServlet("/ValidateShop")
public class ValidateShop extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ValidateShop() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		if(uname.equals("Balu")&& pwd.equals("Balu")) {
			session.setAttribute("username", uname);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Catalog.html");
			dispatcher.forward(request, response);
		
		}else {
			out.println("<h1>Validation here</h1>");
			RequestDispatcher reqd=request.getRequestDispatcher("ErrorServlet");
			reqd.forward(request, response);
		}
	}

}
