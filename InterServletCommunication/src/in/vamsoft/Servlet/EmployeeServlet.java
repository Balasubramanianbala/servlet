package in.vamsoft.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	try {
		String ename=request.getParameter("ename");
		String mob=request.getParameter("cno");
		String doj=request.getParameter("doj");
		
		LocalDate ld=LocalDate.parse(doj, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate curt=LocalDate.now();
		long days=ChronoUnit.MONTHS.between(ld,curt);
		System.out.println(days);
		if(ename==null||mob==null||doj==null ||ename.length()==0||mob.length()==0||doj.length()==0 ) {
			throw  new NullPointerException("null pointer exception");
		}
		if(days<=12) {
			request.setAttribute("salary", 15000);
		}else if(days>=12 && days<=24) {
			request.setAttribute("salary", 20000);
		}else {
			request.setAttribute("salary",30000);
		}
		request.setAttribute("ename", ename);
		request.setAttribute("cno", mob);
		request.setAttribute("doj", doj);
		RequestDispatcher req=request.getRequestDispatcher("SalaryServlet");
		req.forward(request,response);
	}catch(NullPointerException e) {		
		RequestDispatcher req=request.getRequestDispatcher("ErrorempServlet");
		req.forward(request,response);
		}
	}

}
