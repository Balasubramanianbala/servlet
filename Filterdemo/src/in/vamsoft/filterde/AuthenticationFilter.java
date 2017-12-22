package in.vamsoft.filterde;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthenticationFilter
 */
public class AuthenticationFilter extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private ServletContext context;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		String uri=req.getRequestURI();
		this.context.log("Resource request::"+uri);
		HttpSession session=req.getSession(false);
		if(session==null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))) {
			this.context.log("Unauthorized access request");
			res.sendRedirect("Login.html");
		}else {
			chain.doFilter(request,response);
		}
		
	}

	@Override
	public void init(FilterConfig fconfig) throws ServletException {
		 this.context=fconfig.getServletContext();
		 this.context.log("Authentication initailized...");
		
	}

}
