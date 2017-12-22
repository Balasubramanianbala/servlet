package in.vamsoft.filterde;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
			Cookie[] ck=request.getCookies();
			if(ck!=null) {
				for(Cookie c:ck) {
					if(c.getName().equals("JSESSIONID")) {
						System.out.println("JSESSIONID ::"+c.getValue());
						break;
					}
				}
			}
			HttpSession session=request.getSession(false);
			System.out.println("user"+session.getAttribute("user"));
			if(session!=null) {
				session.invalidate();
			}
			response.sendRedirect("Login.html");
	}

}
