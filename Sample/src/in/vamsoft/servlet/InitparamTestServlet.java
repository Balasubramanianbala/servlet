package in.vamsoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitparamTestServlet
 */
public class InitparamTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String coName;
	ServletConfig config;
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		this.config=config;
//		coName=config.getInitParameter("companyName");
//	}
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		ServletConfig config=getServletConfig();
		ServletContext context=this.getServletContext();
		
		String coName=config.getInitParameter("companyName");
		String city=context.getInitParameter("city");
		out.println("<html><body><h1>"+coName+""+city+"</h1></body></html>");
	}

	

}
