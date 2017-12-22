package in.vamsoft.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Getcookie
 */
@WebServlet("/Getcookie")
public class Getcookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		Cookie c[]=request.getCookies();
    		String name="";
    		String color="";
    		if(c!=null) {
    			for(Cookie ck:c) {
    				if(ck.getName().equals("uname")){
    					name=ck.getValue();
    				}if(ck.getName().equals("colour")){
    					color=ck.getValue();
    				}
    				
    			}
    		}
    		response.getWriter().println("<html><body bgcolor='"+color+"'><h1>Welcome"+name+"</h1></body></html>");
	}

}
