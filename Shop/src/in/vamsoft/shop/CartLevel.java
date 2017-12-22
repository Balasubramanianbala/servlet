package in.vamsoft.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartLevel
 */
@WebServlet("/CartLevel")
public class CartLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession=request.getSession();
		String name=httpSession.getAttribute("username").toString();
		PrintWriter out=response.getWriter();
		Map<String, Integer> movie=new TreeMap<>();
		movie.put("mersal", 100);
		movie.put("vivegam", 100);
		movie.put("aval", 80);
		Map<String,Integer> book=new TreeMap<>();
			Map<String, Integer> booked=new TreeMap<>();
			book.put("java", 350);
			book.put("c++", 250);
			book.put("maths", 150);
			Map<String, Integer> toys=new TreeMap<>();
			toys.put("teddybear", 250);
			toys.put("woodentoys", 250);
			toys.put("puzzle", 100);
		if(name==null) {
			response.sendRedirect("Login.html");
		}else {
			String uname=name.toString();
			String select[]=request.getParameterValues("movie");
			String select1[]=request.getParameterValues("book");
			String select2[]=request.getParameterValues("toys");
			response.setContentType("text/html");
			for(String com:select) {
				out.println(com);
				if(movie.containsKey(com)) {
					booked.put(com,movie.get(com));
					
				}else {
					out.println("your selected not in map");
				}	
				for(String com1:select1) {
	                out.println(com1);
	                if(book.containsKey(com1)) {
	                    booked.put(com1,book.get(com1));
	                    
	                }else {
	                    out.println("your selected not in map");
	                }
				
			}
				for(String com2:select2) {
	                out.println(com2);
	                if(toys.containsKey(com2)) {
	                    booked.put(com2,toys.get(com2));
	                    
	                }else {
	                    out.println("your selected not in map");
	                }
			httpSession.setAttribute("selected", booked);
            RequestDispatcher dispatcher=request.getRequestDispatcher("BillServlet");
            dispatcher.forward(request, response);
            System.out.println(booked);
			
		}
	}
		}
	}
		}
