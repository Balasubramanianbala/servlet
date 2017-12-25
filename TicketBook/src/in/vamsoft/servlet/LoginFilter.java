package in.vamsoft.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.dao.UserCreationDao;
import in.vamsoft.pojomodel.UserCreation;

/**
 * Servlet Filter implementation class LoginFilter.
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {

  /**
   * Default constructor.
   */

  public LoginFilter() {

  }

  /**
   * @see Filter#destroy()
   */
  public void destroy() {
    // TODO Auto-generated method stub
  }

  /**
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    // HttpSession session;
    HttpSession session = request.getSession(false);
    String loginURI = request.getContextPath() + "/Login";

    boolean loggedIn = session != null && session.getAttribute("user") != null;
    boolean loginRequest = request.getRequestURI().equals(loginURI);

    if (loggedIn || loginRequest) {
      chain.doFilter(request, response);
    } else {
      response.sendRedirect(loginURI);
    }
  }

  /**
   * @see Filter#init(FilterConfig)
   */
  public void init(FilterConfig fConfig) throws ServletException {
    // TODO Auto-generated method stub
  }

}
