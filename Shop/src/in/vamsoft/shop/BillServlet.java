package in.vamsoft.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession httpSession=request.getSession();
		Object uname=httpSession.getAttribute("username");
		PrintWriter out=response.getWriter();
		if(uname==null) {
			response.sendRedirect("Login.html");
		}else {
			String name=uname.toString();
			Map<String,Integer> billMap=(Map<String, Integer>) httpSession.getAttribute("selected");
			double amount=0.0;
			for (Map.Entry<String, Integer> entry : billMap.entrySet())
			{
			    out.println(entry.getKey() + "\t\t " + entry.getValue());
			    out.println();
			    amount+= entry.getValue();
			}		
			ServletContext context=this.getServletContext();
			String dis=context.getInitParameter("Discount");
			ServletContext cont=this.getServletContext();
			out.println("Discount"+dis);
			String gst=cont.getInitParameter("Gst");
			double d=Double.parseDouble(dis);
			double g=Double.parseDouble(gst);
			d=d*amount;
			double sub=amount-d;
			g=g*amount;
			double tot=amount+g;
			out.println("total amount "+tot);
		}

	}

}
