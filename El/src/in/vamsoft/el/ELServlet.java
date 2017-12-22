package in.vamsoft.el;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ELServlet
 */
@WebServlet("/ELServlet")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		Address add=new Address();
		add.setHouseno("2A");
		add.setCity("Tirunelveli");
		
		Employee e1=new Employee(1,"Balu",4000,LocalDate.now(),20,add);		
		Employee emp = new Employee(2,"jana",4500,LocalDate.now(),30,add);
		
		request.setAttribute("employee", e1);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("employee1", emp);
		
		response.addCookie(new Cookie("User", "Vamsoft"));
		
		ServletContext context =getServletContext();
		context.setAttribute("User.Cookie", "Vamsoft");
		
		RequestDispatcher rd =context.getRequestDispatcher("/Home.jsp");
		rd.forward(request, response);
		

		
	}

}
