package in.vamsoft.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetPerfrenceServlet
 */
@WebServlet("/SetPerfrenceServlet")
public class SetPerfrenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=request.getParameter("uname");
		String colour=request .getParameter("colour");
		Cookie namecookie=new Cookie("uname", name);
		Cookie colcookie=new Cookie("colour", colour);
		response.addCookie(namecookie);
		response.addCookie(colcookie);
		response.getWriter().println("<html> <body><h2>Hello"+name+"your preference have been set</h2></body></html>");
	}

}
