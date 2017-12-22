package in.vamsoft.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SalaryServlet
 */
@WebServlet("/SalaryServlet")
public class SalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uname=(String) request.getAttribute("ename");
		String cno=(String) request.getAttribute("cno");
		String doj=(String) request.getAttribute("doj");
		int salary=(int) request.getAttribute("salary");
		double bonus=salary*0.1;
		double hra=salary*0.1;
		double tax=salary*0.12;
		double total=salary+bonus+hra-tax;
		PrintWriter out=response.getWriter();
		out.println("Name"+uname);
		out.println("Contactno"+cno);
		out.println("Date of joing"+doj);
		out.println(" Salary"+salary);
		out.println(bonus+"");
		out.println("total Salary"+total);
		
	}

}
