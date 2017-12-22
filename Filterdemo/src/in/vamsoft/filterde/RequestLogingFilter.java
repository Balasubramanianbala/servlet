package in.vamsoft.filterde;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestLogingFilter
 */
public class RequestLogingFilter extends HttpServlet implements Filter {
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
		Enumeration<String> parms=req.getParameterNames();
		while (parms.hasMoreElements()) {
			String name = (String) parms.nextElement();
			String value=req.getParameter(name);
			this.context.log(req.getRemoteAddr()+":Request param::{"+name+""+value+"}");		
		}
		Cookie[] ck=req.getCookies();
		if(ck!=null) {
			for(Cookie c:ck) {
				this.context.log(req.getRemoteAddr()+"Cookies::{"+c.getName()+""+c.getValue()+"}");
			}			
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fconfig) throws ServletException {
	
		this.context=fconfig.getServletContext();
		this.context.log("RequestLogingFilter Intialized");
	}

}
